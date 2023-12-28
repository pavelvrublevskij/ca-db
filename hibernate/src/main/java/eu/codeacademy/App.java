package eu.codeacademy;

import java.util.List;

import eu.codeacademy.config.HibernateConfig;
import eu.codeacademy.config.HibernateDaoManagerHelper;
import eu.codeacademy.pojo.EmployeePojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class App {

	public static void main(String[] args) {
		nativeQueryExample();
	}

	private static void nativeQueryExample() {
		NativeQuery<EmployeePojo> query = getSession().createNativeQuery("SELECT * FROM employee", EmployeePojo.class);
		List<EmployeePojo> employees = query.list();

		employees.forEach(System.out::println);
	}

	private static Session getSession() {
		return HibernateDaoManagerHelper.getSessionFactory().openSession();
	}
}
