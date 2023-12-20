package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/ca_app_db",
					"app_user",
					"app_user_password");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}
}
