package org.hibernatetest.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails user where user.userId=1");
		query.setCacheable(true);
		List users = query.list();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		query = session.createQuery("from UserDetails user where user.userId=1");
		query.setCacheable(true);
		users = query.list();

		// System.out.print(user2.getUserName());
		// session.getTransaction().commit();
		session.close();

	}

}
