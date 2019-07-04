package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.UserDetails;

public class TestClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = session.get(UserDetails.class, 1);

		user.setUserName("updated user23");
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user2 = session.get(UserDetails.class, 1);

		System.out.print(user2.getUserName());
		// session.getTransaction().commit();
		session.close();

	}

}
