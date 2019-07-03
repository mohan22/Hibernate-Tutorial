package org.hibernatetest.utils;

import java.util.Date;

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
		user.setAddress("First user's address");
		user.setDescription("description ");
		user.setJoinedDate(new Date());

		Address addr = new Address();
		addr.setCity("hyd");
		addr.setPincode("521366");
		addr.setState("telangana");

		user.setHomeAddress(addr);

		Address ofcaddr = new Address();
		ofcaddr.setCity("vij");
		ofcaddr.setPincode("521366");
		ofcaddr.setState("AP");

		user.setOfficeAddress(ofcaddr);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

}
