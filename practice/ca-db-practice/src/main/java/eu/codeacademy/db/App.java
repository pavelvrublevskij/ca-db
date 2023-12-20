package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/ca_app_db",
					"app_user",
					"app_user_password");

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
