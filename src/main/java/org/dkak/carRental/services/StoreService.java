package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.City;
import org.dkak.carRental.models.Store;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class StoreService {
	
	private Session session = null;
	private Transaction tx = null;
	
	public StoreService() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public List<Store> getAll() {
		
		List<Store> stores = new ArrayList<>();
		tx.commit();
		stores = session.createQuery("from Store", Store.class).getResultList();		
	    session.close();
	    
		return stores;
	}
	
	public Store getStore(String id) {
		Store store = new Store();
		
		store = session.find(Store.class, id);	
		tx.commit();	
		
		if(store == null) {
			throw new DataNotFoundException("City not found");	 			
		} 
		
    	session.close();

		return store;	    
	}

	public Store add(String id, String name, String cityId) {
	
		City city = session.find(City.class, cityId);
		Store existingStore = session.find(Store.class, id);
		
		if(existingStore == null) {
			Store store = new Store(id, name, city);
			
			session.save(store);
			tx.commit();	
	    	session.close();

			return store;
		} else {
			throw new GenericException("Duplicate Entry!");
		}	
	}
	
	public Store update(String id, String name, String cityId) {
		try {
			City city = (City)session.get(City.class, cityId);
			Store store = (Store)session.get(Store.class, id);
			 
			if(store == null) {
				throw new DataNotFoundException("Store not found");	 			
			}
			 
			store.setName(id);
			store.setName(name);
			store.setCity(city);
			 
			session.update(store); 
			
		    tx.commit();
			return store;
		} catch (HibernateException e) {
			throw new GenericException("Unkown Error");
		} finally {
			session.close(); 
		}	  
	}
	
	public Response remove(String id) {	
		try {
			Store store = session.find(Store.class, id);
			
			if(store == null) {
				throw new DataNotFoundException("City not found");	 			
			}
			
			session.delete(store);
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
