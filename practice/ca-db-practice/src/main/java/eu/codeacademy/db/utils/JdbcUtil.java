package eu.codeacademy.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcUtil {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/ca_app_db";
	public static final String DB_USER = "app_user";
	public static final String DB_PASSWORD = "app_user_password";
	private static Connection connection;

	private JdbcUtil() {}

	public static Connection buildConnection() {
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER,	DB_PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			connection = buildConnection();
		}
		return connection;
	}
}
