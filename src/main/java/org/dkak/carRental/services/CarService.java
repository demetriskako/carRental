package org.dkak.carRental.services;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.models.City;
import org.dkak.carRental.models.Store;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class CarService {
	
	private Session session = null;
	private Transaction tx = null;
	private static String type = "Car";
	
	public CarService() {
		session = HibernateUtil.getSessionFactory();
		tx = session.beginTransaction();
	}

	public Car add(String licence, String vehicle_type, String model, String fuel, int cost,
			String capacity, String storeId, int doors, int seats) {

		try{
			Car existingCar = session.find(Car.class, licence);
			Store store = session.find(Store.class, storeId);

			if(existingCar == null) {
				Car car= new Car(licence, model, fuel, capacity, cost, type, vehicle_type, store, doors, seats);
				session.save(car);
				tx.commit();
				session.close();

				return car;
			}else {
				session.close();

				throw new GenericException("Duplicate Entry!");
			}
		}catch (HibernateException e) {
			throw new GenericException("Unknown Error");
		} finally {
			session.close();
		}
	}
	
	public Car update(String licence, String vehicle_type, String model, String fuel, int cost,
					   String capacity, String storeId, int doors, int seats) {

		try {
			Car existingCar = session.find(Car.class, licence);
			Store store = session.find(Store.class, storeId);

			if (existingCar != null) {
				existingCar.setLicence(licence);
				existingCar.setVehicle_type(vehicle_type);
				existingCar.setModel(model);
				existingCar.setFuel(fuel);
				existingCar.setCost(cost);
				existingCar.setCapacity(capacity);
				existingCar.setStore(store);
				existingCar.setDoors(doors);
				existingCar.setSeats(seats);
				session.update(existingCar);
				tx.commit();
				session.close();

				return existingCar;
			} else {
				session.close();

				throw new DataNotFoundException("Car did not exist!");
			}
		}catch (HibernateException e) {
			session.close();
			throw new GenericException("Unknown Error");
		} finally {
			session.close();
		}
	}

}
