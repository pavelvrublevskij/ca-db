package eu.codeacademy;

import eu.codeacademy.config.HibernateConfig;
import eu.codeacademy.config.HibernateDaoManagerHelper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateDaoManagerHelper.getSessionFactory();

		System.out.println("Hi from hibernate!!");
	}
}
