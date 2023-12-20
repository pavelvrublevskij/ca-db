package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.codeacademy.db.utils.JdbcUtil;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) throws SQLException {
			Connection connection = JdbcUtil.buildConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next()) {
				String surnameFromDB = resultSet.getString("surname");
				System.out.println("Surname from db: " + surnameFromDB);
			}

			System.out.println("Database connected successfully!");
	}
}
