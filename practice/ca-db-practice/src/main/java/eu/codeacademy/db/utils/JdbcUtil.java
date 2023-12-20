package eu.codeacademy.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcUtil {

	private JdbcUtil() {}

	public static Connection buildConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/ca_app_db",
					"app_user",
					"app_user_password");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR -> Connection into database has a problem: " + e.getMessage());
		}
	}
}
