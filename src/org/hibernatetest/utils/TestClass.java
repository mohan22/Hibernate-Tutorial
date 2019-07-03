package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.UserDetails;
import org.hibernatetest.Vehicle;

public class TestClass {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");

		Vehicle v = new Vehicle();
		v.setVehicleName("car");
		user.setVehicle(v);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(v);
		session.getTransaction().commit();
		session.close();

	}

}
