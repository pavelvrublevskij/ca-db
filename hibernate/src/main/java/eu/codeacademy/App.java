package eu.codeacademy;

import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure().buildSessionFactory();

		System.out.println("Hi from hibernate!!");
	}
}
