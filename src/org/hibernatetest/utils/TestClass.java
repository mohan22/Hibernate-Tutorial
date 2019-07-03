package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.UserDetails;

public class TestClass {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("u22");
		user.setUserName("Updated user name"); // user - Transient object

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user); // user - persisted object

		session.getTransaction().commit();
		session.close(); // user- Detached object
		// System.out.println("User name :" + user.getUserName());

	}

}
