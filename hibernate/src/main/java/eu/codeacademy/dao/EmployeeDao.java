package eu.codeacademy.dao;

import java.util.List;

import eu.codeacademy.pojo.EmployeePojo;
import org.hibernate.Session;

public class EmployeeDao {

	private final Session session;

	public EmployeeDao(Session session) {
		this.session = session;
	}

	// R - Read
	public List<EmployeePojo> getAll() {
		return session.createQuery("FROM EmployeePojo", EmployeePojo.class).list();
	}

	public EmployeePojo getOneById(Long id) {
		return session.get(EmployeePojo.class, id);
	}

	// C - Create or U - Update
	public void persist(EmployeePojo employeePojo) {
		session.merge(employeePojo);
	}


	// D - Delete
	public void delete(EmployeePojo employeePojo) {
		session.remove(employeePojo);
	}

	public void deleteById(Long id) {
		EmployeePojo employeePojo = getOneById(id);
		if (employeePojo != null) {
			session.remove(employeePojo);
		}
	}
}
