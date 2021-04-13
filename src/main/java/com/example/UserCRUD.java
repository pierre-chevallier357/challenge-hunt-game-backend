package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserCRUD {
	@Autowired
	private DataSource dataSource;

	@GetMapping("/")
	public ArrayList<User> allUsers(HttpServletResponse response) {
		ArrayList<User> users = new ArrayList<>();

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT login, age FROM chamis"
			);

			ResultSet r = statement.executeQuery();
			while (r.next()) {
				User user = new User(
						r.getString("login"),
						r.getInt("age")
				);
				users.add(user);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return users;
	}

	@GetMapping("/{userId}")
	public User read(@PathVariable(value = "userId") String id, HttpServletResponse response) {
		User user = null;
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT login, age FROM chamis WHERE login = ?"
			);
			statement.setString(1,id);

			ResultSet r = statement.executeQuery();
			if (r.next()) {
				user = new User(
						r.getString(1),
						r.getInt(2)
				);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return user;
	}

	@PostMapping("/{userId}")
	public User create(@PathVariable(value = "userId") String id, @RequestBody User u, HttpServletResponse response) {
		if (!u.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO chamis (login, age) VALUES (?, ?)"
			);
			statement.setString(1, u.getLogin());
			statement.setInt(2, u.getAge());

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}

		return u;
	}

	@PutMapping("/{userId}")
	User update(@PathVariable(value = "userId") String id, @RequestBody User u, HttpServletResponse response) {
		if (!u.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE chamis SET login = ?, age = ? WHERE login = ?"
			);
			statement.setString(1, u.getLogin());
			statement.setInt(2, u.getAge());
			statement.setString(3, id);

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return u;
	}

	@DeleteMapping("/{userId}")
	void delete(@PathVariable(value = "userId") String id, HttpServletResponse response) {
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM chamis WHERE login = ?"
			);
			statement.setString(1, id);

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
