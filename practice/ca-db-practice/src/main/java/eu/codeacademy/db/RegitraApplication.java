package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import eu.codeacademy.db.service.PersonService;
import eu.codeacademy.db.utils.JdbcUtil;

public final class RegitraApplication {

	public void run() {
		Connection connection = JdbcUtil.buildConnection();

		PersonService personService = new PersonService(connection);
		List<String> personSurnames = personService.getPersonSurnames();

		personSurnames.forEach(value -> System.out.println("Surname from db: " + value));

	}

}
