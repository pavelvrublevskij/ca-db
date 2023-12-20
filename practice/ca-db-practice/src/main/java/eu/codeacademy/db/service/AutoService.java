package eu.codeacademy.db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.codeacademy.db.model.Auto;
import eu.codeacademy.db.model.Person;

public class AutoService {

	private final Connection connection;

	public AutoService(Connection connection) {
		this.connection = connection;
	}

	public void save(Auto auto) throws SQLException {
		try {
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO auto (number) VALUES (?)");
			statement.setString(1, auto.getNumber());
			statement.execute();

			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.setAutoCommit(true);
		}
	}

	public List<Auto> getAll() {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM auto");

			final List<Auto> autos = new ArrayList<>();
			while (resultSet.next()) {
				String number = resultSet.getString("number");

				autos.add(new Auto(number));
			}

			return autos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}
}
