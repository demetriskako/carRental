package org.dkak.carRental.services;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.models.Vehicle;
import org.dkak.carRental.utils.HibernateUtil;
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
		
		List<Vehicle> vehicles;

		tx.commit();
		vehicles = session.createQuery("from Vehicle", Vehicle.class).getResultList();
	    session.close();
	    
		return vehicles;
	}
	
	public Vehicle show(String id) {
		Vehicle vehicle;

		vehicle = session.find(Vehicle.class, id);
		tx.commit();

		session.close();

		if(vehicle == null) {
			throw new DataNotFoundException("City not found");	 			
		} 
		

		return vehicle;	    
	}

	public Response remove(String id) {
		try {
			Vehicle vehicle = session.find(Vehicle.class, id);

			if(vehicle == null) {
				session.close();

				throw new DataNotFoundException("Vehicle not found");
			}

			session.delete(vehicle);
			tx.commit();

			SuccessMessage successMessage = new SuccessMessage("Vehicle deleted successfully");

			return Response.status(Status.OK)
					.entity(successMessage)
					.build();
		} catch (Throwable e) {
			throw new GenericException("Unknown Error");
	    }  finally {
	    	 session.close();
	    }
	}
}
