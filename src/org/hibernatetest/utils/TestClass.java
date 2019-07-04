package org.hibernatetest.utils;

import java.util.List;

import org.hibernate.Query;
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

		Query query = session.createQuery("from UserDetails ");
		query.setFirstResult(5);
		query.setMaxResults(3);
		List<UserDetails> users = query.list();
		// session.getTransaction().commit();
		session.close();
		for (UserDetails u : users)
			System.out.println(u.getUserName());

	}

}
