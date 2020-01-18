package org.dkak.carRental.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Client;
import org.dkak.carRental.models.SuccessMessage;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;


public class ClientService {
	
	private Session session = null;
	private Transaction tx = null;
	
	public ClientService() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public List<Client> getAll() {
		
		List<Client> clients = new ArrayList<>();
		tx.commit();
		clients = session.createQuery("from Client", Client.class).getResultList();		
	    session.close();
	    
		return clients;
	}
	
	public Client show(String id) {
		Client Client = new Client();
		
		Client = session.find(Client.class, id);	
		tx.commit();	
		
		if(Client == null) {
			throw new DataNotFoundException("Client not found");	 			
		} 
		
    	session.close();

		return Client;	    
	}
	
	public Client create(String id, String name, String surname, String licence, String email, String tel, String address) {
	
		Client existingClient = session.find(Client.class, id);

		if(existingClient == null) {
			Client client = new Client(id, name, surname, licence, email, tel, address);
			
			session.save(client);
			tx.commit();	
	    	session.close();

			return client;
		}else {
			throw new GenericException("Duplicate Entry!");
		}	
	}
	
	public Client update(String id, String newId, String name, String surname, String licence, String email, String tel, String address) {
		try {
			Client existingClient = session.find(Client.class, id);
			 
			if(existingClient == null) {
				throw new DataNotFoundException("Client not found");	 			
			}
			 
			existingClient.setName(name);
			existingClient.setSurname(surname);
//			existingClient.setId(newId);
			existingClient.setAddress(address);
			existingClient.setEmail(email);
			existingClient.setTel(tel);
			existingClient.setAddress(address);

			session.update(existingClient); 
			
		    tx.commit();
			return existingClient;
		} catch (HibernateException e) {
			throw new GenericException("Unkown Error");
		} finally {
			session.close(); 
		}	  
	}
	
	public Response remove(String id) {	
		try {
			Client currentClient = session.find(Client.class, id);
			
			if(currentClient == null) {
				throw new DataNotFoundException("Client not found");	 			
			}
			
			session.delete(currentClient);
			tx.commit();	
			SuccessMessage successMessage = new SuccessMessage("Client deleted succesfully");
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
