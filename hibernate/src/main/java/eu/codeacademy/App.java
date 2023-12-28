package eu.codeacademy;

import eu.codeacademy.config.HibernateConfig;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		HibernateConfig.init();

		System.out.println("Hi from hibernate!!");
	}
}
