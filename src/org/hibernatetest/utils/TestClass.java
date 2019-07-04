package org.hibernatetest.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernatetest.UserDetails;

public class TestClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(3);
		exampleUser.setUserName("user 3");

		Example example = Example.create(exampleUser);

		Criteria criteria = session.createCriteria(UserDetails.class).add(example);

		List<UserDetails> users = criteria.list();
		// session.getTransaction().commit();
		session.close();
		for (UserDetails u : users)
			System.out.println(u.getUserName());

	}

}
