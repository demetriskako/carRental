package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.models.City;
import org.dkak.carRental.models.Store;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.models.TwoWheeled;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class TwoWheeledService {
	
	private Session session = null;
	private Transaction tx = null;
	private static String type = "TwoWheeled";


	public TwoWheeledService() {
		session = HibernateUtil.getSessionFactory();
		tx = session.beginTransaction();
	}

	public TwoWheeled add(String licence, String vehicle_type, String model, String fuel, int cost,
			String capacity, String storeId, int seatHeight, String luggage) {

		TwoWheeled existingTwoWheeled = session.find(TwoWheeled.class, licence);
		Store store = session.find(Store.class, storeId);

		try {
			if (existingTwoWheeled == null) {
				TwoWheeled twoWheeled = new TwoWheeled(licence, model, fuel, capacity, cost, type, vehicle_type, store, seatHeight, luggage);
				session.save(twoWheeled);
				tx.commit();
				session.close();

				return twoWheeled;
			} else {
				session.close();
				throw new GenericException("Duplicate Entry!");
			}
		}catch (HibernateException e) {
			throw new GenericException("Unknown Error");
		} finally {
			session.close();
		}
	}
	
	public TwoWheeled update(String licence, String vehicle_type, String model, String fuel, int cost,
					   String capacity, String storeId, int seatHeight, String luggage) {

		try {
			TwoWheeled existingMoto = session.find(TwoWheeled.class, licence);
			Store store = session.find(Store.class, storeId);

			if (existingMoto != null) {
				existingMoto.setLicence(licence);
				existingMoto.setVehicle_type(vehicle_type);
				existingMoto.setModel(model);
				existingMoto.setFuel(fuel);
				existingMoto.setCost(cost);
				existingMoto.setCapacity(capacity);
				existingMoto.setStore(store);
				existingMoto.setLuggage(luggage);
				existingMoto.setSeatHeight(seatHeight);

				session.update(existingMoto);
				tx.commit();
				session.close();

				return existingMoto;
			} else {
				session.close();
				throw new DataNotFoundException("Moto did not exist!");
			}

		}catch (HibernateException e) {
			session.close();
			throw new GenericException("Unknown Error");
		} finally {
			session.close();
		}
	}

}
