package eu.codeacademy.config;

import eu.codeacademy.pojo.EmployeePojo;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	public static Configuration initConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/paskaita_hibernate");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root_password");
		configuration.setProperty("hibernate.connection.autocommit", "true");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		configuration.addAnnotatedClass(EmployeePojo.class);

		return configuration;
	}
}
