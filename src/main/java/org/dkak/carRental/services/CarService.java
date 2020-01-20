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
import org.dkak.carRental.models.Car;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class CarService {
	
	private Session session = null;
	private Transaction tx = null;
	
	public CarService() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
//	public List<Car> getAll() {
//		
//		List<Car> Cars = new ArrayList<>();
//		tx.commit();
//		Cars = session.createQuery("from Car", Car.class).getResultList();		
//	    session.close();
//	    
//		return Cars;
//	}
	
//	public City show(String id) {
//		City city = new City();
//		
//		city = session.find(City.class, id);	
//		tx.commit();	
//		
//		if(city == null) {
//			throw new DataNotFoundException("City not found");	 			
//		} 
//		
//    	session.close();
//
//		return city;	    
//	}
//	
	public Car add(String licence, String type, String model, String fuel, int cost, 
			String capacity, String storeId, int doors, int seats) {
	
		Car existingCar = session.find(Car.class, licence);
		Store store = session.find(Store.class, storeId);
		
		if(existingCar == null) {
			Car car= new Car(licence, model, fuel, capacity, cost, type, store, doors, seats);
			session.save(car);
			tx.commit();	
			
	    	session.close();
	    	
			return car;
		}else {
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
//	
//	public Response remove(String id) {	
//		try {
//			City currentCity = session.find(City.class, id);
//			
//			if(currentCity == null) {
//				throw new DataNotFoundException("City not found");	 			
//			}
//			
//			session.delete(currentCity);
//			tx.commit();	
//			SuccessMessage successMessage = new SuccessMessage("City deleted succesfully");
//			return Response.status(Status.OK)
//					.entity(successMessage)
//					.build(); 
//		} catch (Throwable e) { 
//			throw new GenericException("Unkown Error");
//	    }  finally {
//	    	 session.close();
//	    }				
//	}
}
