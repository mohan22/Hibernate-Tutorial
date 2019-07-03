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

		Vehicle v1 = new Vehicle();
		v1.setVehicleName("car");
		user.getVehicles().add(v1);
		Vehicle v2 = new Vehicle();
		v2.setVehicleName("Jeep");
		user.getVehicles().add(v2);
		v2.setUser(user);
		v1.setUser(user);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(v1);
		session.save(v2);
		session.getTransaction().commit();
		session.close();

	}

}
