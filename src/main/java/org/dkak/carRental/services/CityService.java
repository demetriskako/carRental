package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;


import org.dkak.carRental.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CityService {
	SessionFactory sessionFactory = null;
	Session session = null;
	
	public CityService() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public List<City> getAllCities() {
		
		List<City> cities = new ArrayList<City>();
		
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			
			Query<City> query = session.createQuery("FROM city");		
			cities = query.getResultList();
			System.out.print(cities);
		} catch (Throwable ex) { 
			//			 
	    }  finally {
	    	session.close();
	    }
		
		return cities;
	}
}
