package eu.codeacademy;

import java.util.List;

import eu.codeacademy.config.HibernateConfig;
import eu.codeacademy.config.HibernateDaoManagerHelper;
import eu.codeacademy.pojo.EmployeePojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		System.out.println("Get data using native query (SQL)");
		nativeQueryExample();

		System.out.println("Get data using hibernate query (HQL)");
		hqlQueryExample();
	}

	private static void hqlQueryExample() {
		try (Session session = getSession()) {
			Query<EmployeePojo> query = session.createQuery("FROM EmployeePojo", EmployeePojo.class);
			List<EmployeePojo> employees = query.list();

			employees.forEach(System.out::println);
		}
	}

	private static void nativeQueryExample() {
		try (Session session = getSession()) {
			NativeQuery<EmployeePojo> query = session.createNativeQuery("SELECT * FROM employee", EmployeePojo.class);
			List<EmployeePojo> employees = query.list();

			employees.forEach(System.out::println);
		}
	}

	private static Session getSession() {
		return HibernateDaoManagerHelper.getSessionFactory().openSession();
	}
}
