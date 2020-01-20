package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.models.City;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.models.TwoWheeled;
import org.dkak.carRental.models.Vehicle;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class VehicleService {
	
	private Session session = null;
	private Transaction tx = null;
	
	public VehicleService() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public List<Vehicle> getAll() {
		
		List<Vehicle> vehicles = new ArrayList<>();
		tx.commit();
		vehicles = session.createQuery("from Vehicle", Vehicle.class).getResultList();		
	    session.close();
	    
		return vehicles;
	}
	
	public Vehicle show(String id) {
		Vehicle vehicle = new Vehicle();
		
		vehicle = session.find(Vehicle.class, id);	
		tx.commit();	
		
		if(vehicle == null) {
			throw new DataNotFoundException("City not found");	 			
		} 
		
    	session.close();

		return vehicle;	    
	}
	
//	public Car addCar(String licence, String type, String model, String fuel, int cost, 
//			String capacity, int doors, int seats, String store) {
//	
//		Car existingCar = session.find(Car.class, licence);
//		
//		if(existingCar == null) {
//			System.out.print("Hello");
//			Car car= new Car(licence, type, model, fuel, cost, capacity, store, doors, seats);
//			session.save(car);
//			tx.commit();	
//			
//	    	session.close();
//	    	
//			return car;
//		}else {
//			throw new GenericException("Duplicate Entry!");
//		}	
//	}
	
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
