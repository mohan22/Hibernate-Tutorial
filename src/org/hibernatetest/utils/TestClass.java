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

		int minUserId = 5;
		String userName = "user 8";
		Query query = session.createQuery("from UserDetails where userId>:userId and userName=:userName");
		query.setInteger("userId", minUserId);
		query.setString("userName", userName);
		List<UserDetails> users = query.list();
		// session.getTransaction().commit();
		session.close();
		for (UserDetails u : users)
			System.out.println(u.getUserName());

	}

}
