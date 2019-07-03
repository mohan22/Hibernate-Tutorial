package org.hibernatetest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatetest.FourWheeler;
import org.hibernatetest.TwoWheeler;
import org.hibernatetest.Vehicle;

public class TestClass {

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle();
		v1.setVehicleName("car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("bike steering handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Ferrari");
		car.setSteeringWheel("Ferrari steering wheel");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(v1);
		session.save(car);
		session.save(bike);

		session.getTransaction().commit();
		session.close();

	}

}
