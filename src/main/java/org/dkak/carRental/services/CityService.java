package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.City;
import org.dkak.carRental.models.SuccessMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CityService {
	
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;
	
	public CityService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}
	
	public List<City> getAllCities() {
		
		List<City> cities = new ArrayList<City>();
		
		try {
			cities = session.createNativeQuery("SELECT * FROM city").list();		
			tx.commit();	
		} catch (Throwable ex) { 
			return cities;		 
	    }  finally {
	    	session.close();
	    }	
		
		return cities;
	}
	
	public City getCity(String id) {
		City city = new City();
		
		city = session.find(City.class, id);	
		tx.commit();	
		
		if(city == null) {
			throw new DataNotFoundException("City not found");	 			
		} 
		
    	session.close();

		return city;	    
	}
	
	public City add(City city) {
	
		City existingCity = session.find(City.class, city.getId());
		if(existingCity == null) {
			session.save(city);
			tx.commit();	
	    	session.close();

			return city;
		}else {
			throw new GenericException("Duplicate Entry!");
		}	
	}
	
	public City update(String id, City city) {
		try {
			City currentCity = (City)session.get(City.class, id); 
			 
			if(currentCity == null) {
				throw new DataNotFoundException("City not found");	 			
			}
			 
			currentCity.setName(city.getName());
			 
			session.update(currentCity); 
		    tx.commit();
			return currentCity;
		} catch (HibernateException e) {
			throw new GenericException("Unkown Error");
		} finally {
			session.close(); 
		}	  
	}
	
	public Response remove(String id) {	
		try {
			City currentCity = session.find(City.class, id);
			
			if(currentCity == null) {
				throw new DataNotFoundException("City not found");	 			
			}
			
			session.delete(currentCity);
			tx.commit();	
			SuccessMessage successMessage = new SuccessMessage("City deleted succesfully");
			return Response.status(Status.OK)
					.entity(successMessage)
					.build(); 
		} catch (Throwable e) { 
			throw new GenericException("Unkown Error");
	    }  finally {
	    	 session.close();
	    }				
	}
}
