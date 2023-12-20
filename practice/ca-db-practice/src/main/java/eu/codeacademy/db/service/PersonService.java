package eu.codeacademy.db.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonService {

	private final Connection connection;

	public PersonService(Connection connection) {
		this.connection = connection;
	}

	public List<String> getPersonSurnames() {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next()) {
				String surnameFromDB = resultSet.getString("surname");
				System.out.println("Surname from db: " + surnameFromDB);
			}

			return null;  // FIXME: pataisyti cia
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}

}
