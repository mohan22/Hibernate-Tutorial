package org.hibernatetest.utils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernatetest.UserDetails;

public class TestClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.between("userId", 1, 3), Restrictions.eqOrIsNull("userId", 4)));

		List<UserDetails> users = criteria.list();
		// session.getTransaction().commit();
		session.close();
		for (UserDetails u : users)
			System.out.println(u.getUserName());

	}

}
