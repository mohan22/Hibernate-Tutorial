package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.Address;
import org.hibernatetest.UserDetails;

public class TestClass {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");

		Address addr = new Address();
		addr.setCity("hyd");
		addr.setPincode("521366");
		addr.setState("telangana");

		Address ofcaddr = new Address();
		ofcaddr.setCity("vij");
		ofcaddr.setPincode("521366");
		ofcaddr.setState("AP");

		user.getAddresses().add(ofcaddr);
		user.getAddresses().add(addr);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		user = null;
		session = sessionFactory.openSession();
		user = session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getAddresses().size());

	}

}
