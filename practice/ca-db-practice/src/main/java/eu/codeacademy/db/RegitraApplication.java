package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import eu.codeacademy.db.model.Person;
import eu.codeacademy.db.service.PersonService;
import eu.codeacademy.db.utils.JdbcUtil;

public final class RegitraApplication {

	private PersonService personService;

	public void run() {
		Connection connection = JdbcUtil.buildConnection();

		personService = new PersonService(connection);
		getSurnameExample();
		getPersonAsObjectExample();
	}

	private void getPersonAsObjectExample() {
		List<Person> persons = personService.getAll();
		persons.forEach(System.out::println);
	}

	private void getSurnameExample() {
		List<String> personSurnames = personService.getPersonSurnames();

		personSurnames.forEach(value -> System.out.println("Surname from db: " + value));
	}

}
