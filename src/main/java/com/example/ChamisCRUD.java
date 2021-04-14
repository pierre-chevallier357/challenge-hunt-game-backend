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
@RequestMapping("/api/chamis")
public class ChamisCRUD {
	@Autowired
	private DataSource dataSource;

	@GetMapping("/")
	public ArrayList<Chamis> allChamis(HttpServletResponse response) {
		ArrayList<Chamis> lesChamis = new ArrayList<>();

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT login, age FROM chamis"
			);

			ResultSet r = statement.executeQuery();
			while (r.next()) {
				Chamis chamis = new Chamis(
						r.getString("login"),
						r.getInt("age")
				);
				lesChamis.add(chamis);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return lesChamis;
	}

	@GetMapping("/{ChamisId}")
	public Chamis read(@PathVariable(value = "ChamisId") String id, HttpServletResponse response) {
		Chamis chamis = null;
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT login, age FROM chamis WHERE login = ?"
			);
			statement.setString(1,id);

			ResultSet r = statement.executeQuery();
			if (r.next()) {
				chamis = new Chamis(
						r.getString(1),
						r.getInt(2)
				);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return chamis;
	}

	@PostMapping("/{ChamisId}")
	public Chamis create(@PathVariable(value = "ChamisId") String id, @RequestBody Chamis c, HttpServletResponse response) {
		if (!c.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO chamis (login, age) VALUES (?, ?)"
			);
			statement.setString(1, c.getLogin());
			statement.setInt(2, c.getAge());

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}

		return c;
	}

	@PutMapping("/{ChamisId}")
	Chamis update(@PathVariable(value = "ChamisId") String id, @RequestBody Chamis c, HttpServletResponse response) {
		if (!c.getLogin().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE chamis SET login = ?, age = ? WHERE login = ?"
			);
			statement.setString(1, c.getLogin());
			statement.setInt(2, c.getAge());
			statement.setString(3, id);

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return c;
	}

	@DeleteMapping("/{ChamisId}")
	void delete(@PathVariable(value = "ChamisId") String id, HttpServletResponse response) {
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
