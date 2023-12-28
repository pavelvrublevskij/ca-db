package eu.codeacademy.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDaoManagerHelper {

	public static SessionFactory getSessionFactory() {
		Configuration cfg = HibernateConfig.initConfiguration();

		return cfg.buildSessionFactory();
	}
}
