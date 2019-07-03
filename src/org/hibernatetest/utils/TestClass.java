package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.UserDetails;

public class TestClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// for (int i = 1; i < 10; i++) {
		// UserDetails user = new UserDetails();
		// user.setUserName("user " + i);
		// session.save(user);
		// }

		UserDetails user = session.get(UserDetails.class, 6);

		session.getTransaction().commit();
		session.close();
		System.out.println("User name :" + user.getUserName());

	}

}
