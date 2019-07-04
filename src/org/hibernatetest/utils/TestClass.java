package org.hibernatetest.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails where userId>5");
		List users = query.list();
		// session.getTransaction().commit();
		session.close();
		System.out.println("size = " + users.size());

	}

}
