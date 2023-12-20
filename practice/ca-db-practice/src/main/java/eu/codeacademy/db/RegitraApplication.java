package eu.codeacademy.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import eu.codeacademy.db.model.Auto;
import eu.codeacademy.db.model.Person;
import eu.codeacademy.db.service.AutoService;
import eu.codeacademy.db.service.PersonService;
import eu.codeacademy.db.utils.JdbcUtil;

public final class RegitraApplication {

	private PersonService personService;
	private AutoService autoService;

	public void run() {
		Connection connection = JdbcUtil.buildConnection();

		personService = new PersonService(connection);
		autoService = new AutoService(connection);
		getSurnameExample();
		getPersonAsObjectExample();
		doAutoSaveExample();
	}

	private void doAutoSaveExample() {
		try {
			Auto auto = new Auto("AAA111");
			autoService.save(auto);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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
