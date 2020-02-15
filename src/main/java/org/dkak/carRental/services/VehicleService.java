package org.dkak.carRental.services;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Rental;
import org.dkak.carRental.models.Store;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.models.Vehicle;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class VehicleService {
	
	private Session session = null;
	private Transaction tx = null;
	
	public VehicleService() {
		session = HibernateUtil.getSessionFactory();
		tx = session.beginTransaction();
	}
	
	public List<Vehicle> getAll() {

		List<Vehicle> vehicles;

		tx.commit();
		vehicles = session.createQuery("from Vehicle", Vehicle.class).getResultList();
	    session.close();
	    
		return vehicles;
	}

	public List<Vehicle> search(String vehicle_type, String delivery_place, String delivery_date, String return_place, String return_date, int cost) throws ParseException {

		List<Vehicle> vehicles = null;

		List<Store> stores =  session.createQuery("from Store S where S.city.id = :delivery_place", Store.class)
				.setParameter("delivery_place", delivery_place)
				.getResultList();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date deliveryDatetime = formatter.parse(delivery_date);
		java.sql.Date sqlDeliveryDate = new java.sql.Date(deliveryDatetime.getTime());
		Date returnDatetime = formatter.parse(return_date);

		List<String> activeRents = session.createQuery("select vehicle.licence from Rental R" +
                " where R.returnDatetime > :delivery_date", String.class)
				.setParameter("delivery_date", sqlDeliveryDate)
				.getResultList();

		if(activeRents.isEmpty()){
			vehicles = session.createQuery("from Vehicle V where V.vehicle_type = :vehicle_type " +
						"and V.store in (:stores) and V.cost <= :cost", Vehicle.class)
						.setParameter("vehicle_type", vehicle_type)
						.setParameter("stores", stores)
						.setParameter("cost", cost)
						.getResultList();
		}else {
			vehicles = session.createQuery("from Vehicle V where V.vehicle_type = :vehicle_type " +
						"and V.store in (:stores) and V.cost <= :cost and V.id not in :activeRentals", Vehicle.class)
						.setParameter("vehicle_type", vehicle_type)
						.setParameter("stores", stores)
						.setParameter("cost", cost)
						.setParameter("activeRentals", activeRents)
						.getResultList();
		}

		tx.commit();
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
