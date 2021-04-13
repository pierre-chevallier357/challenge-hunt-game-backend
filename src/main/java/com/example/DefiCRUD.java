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
@RequestMapping("/api/defis")
public class DefiCRUD {
	@Autowired
	private DataSource dataSource;

	@GetMapping("/")
	public ArrayList<Defi> allDefis(HttpServletResponse response) {
		ArrayList<Defi> defis = new ArrayList<>();

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT id, titre, datedecreation, description FROM defis"
			);

			ResultSet r = statement.executeQuery();
			while (r.next()) {
				Defi defi = new Defi(
						r.getString("id"),
						r.getString("titre"),
						r.getString("datedecreation"),
						r.getString("description")
				);
				defis.add(defi);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return defis;
	}

	@GetMapping("/{defiId}")
	public Defi read(@PathVariable(value = "defiId") String id, HttpServletResponse response) {
		Defi defi = null;

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT id, titre, datedecreation, description FROM defis WHERE id = ?"
			);
			statement.setString(1, id);

			ResultSet r = statement.executeQuery();
			if (r.next()) {
				defi = new Defi(
						r.getString("id"),
						r.getString("titre"),
						r.getString("datedecreation"),
						r.getString("description")
				);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return defi;
	}

	@PostMapping("/{defiId}")
	public Defi create(@PathVariable(value = "defiId") String id, @RequestBody Defi d, HttpServletResponse response) {
		if (!d.getId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO defis (id, titre, datedecreation, description) VALUES (?, ?, TO_TIMESTAMP(?, 'DD-MM-YYYY HH24:MI'), ?)"
			);
			statement.setString(1, d.getId());
			statement.setString(2, d.getTitre());
			statement.setString(3, d.getDatedecreation());
			statement.setString(4, d.getDescritption());

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}

		return d;
	}

	@PutMapping("/{defiId}")
	Defi update(@PathVariable(value = "defiId") String id, @RequestBody Defi d, HttpServletResponse response) {
		if (!d.getId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
		}

		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE defis SET id = ?, titre = ?, datedecreation = TO_TIMESTAMP(?, 'DD-MM-YYYY HH24:MI'), description = ? WHERE id = ?"
			);
			statement.setString(1, d.getId());
			statement.setString(2, d.getTitre());
			statement.setString(3, d.getDatedecreation());
			statement.setString(4, d.getDescritption());
			statement.setString(5, id);

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return d;
	}

	@DeleteMapping("/{defiId}")
	void delete(@PathVariable(value = "defiId") String id, HttpServletResponse response) {
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM defis WHERE id = ?"
			);
			statement.setString(1, id);

			statement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
