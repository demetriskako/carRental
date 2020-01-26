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
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public TwoWheeled add(String licence, String vehicle_type, String model, String fuel, int cost,
			String capacity, String storeId, int seatHeight, String luggage) {
	
		TwoWheeled existingTwoWheeled = session.find(TwoWheeled.class, licence);
		Store store = session.find(Store.class, storeId);
		
		if(existingTwoWheeled == null) {
			TwoWheeled twoWheeled= new TwoWheeled(licence, model, fuel, capacity, cost, type, vehicle_type, store, seatHeight, luggage);
			session.save(twoWheeled);
			tx.commit();	
			
	    	session.close();
	    	
			return twoWheeled;
		}else {
			session.close();

			throw new GenericException("Duplicate Entry!");
		}	
	}
	
//	public City update(String id, String name) {
//		try {
//			City currentCity = (City)session.get(City.class, id); 
//			 
//			if(currentCity == null) {
//				throw new DataNotFoundException("City not found");	 			
//			}
//			 
//			currentCity.setName(name);
//			 
//			session.update(currentCity); 
//			
//		    tx.commit();
//			return currentCity;
//		} catch (HibernateException e) {
//			throw new GenericException("Unkown Error");
//		} finally {
//			session.close(); 
//		}	  
//	}

}
