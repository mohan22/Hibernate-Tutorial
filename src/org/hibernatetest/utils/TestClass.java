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

		Query query = session.createQuery("select userName from UserDetails ");
		query.setFirstResult(5);
		query.setMaxResults(2);
		List<String> userNames = query.list();
		// session.getTransaction().commit();
		session.close();
		for (String u : userNames)
			System.out.println(u);

	}

}
