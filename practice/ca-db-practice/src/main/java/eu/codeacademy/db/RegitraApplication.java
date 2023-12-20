package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.codeacademy.db.utils.JdbcUtil;

public final class RegitraApplication {

	public void run() {
		Connection connection = JdbcUtil.buildConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next()) {
				String surnameFromDB = resultSet.getString("surname");
				System.out.println("Surname from db: " + surnameFromDB);
			}

			System.out.println("Database connected successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}

}
