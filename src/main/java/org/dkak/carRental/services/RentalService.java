package org.dkak.carRental.services;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dkak.carRental.exceptions.DataNotFoundException;
import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.*;
import org.dkak.carRental.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;
import javax.ws.rs.core.Response;

public class RentalService {
    private Transaction tx = null;
    private Session session = null;
    private ClientService clientService = new ClientService();

    public RentalService() {
        this.session = HibernateUtil.getSessionFactory();
        this.tx = session.beginTransaction();
    }

    public List<Rental> search(){
        return null;
    }

    public Rental add(String licence, String delivery_place, String delivery_date,
                     String return_place, String return_date, String client_id, int cost,
                     String clientID,  String name, String surname,
                     String drivingLicense, String email,
                     String address, String tel) throws ParseException {

        Client client = null;

        if(clientID != null && name != null && surname != null && drivingLicense != null && email != null && address != null && tel != null ){
            client = clientService.create(clientID, name, surname, drivingLicense, email, tel, address);
        }else {
            client = session.find(Client.class, client_id);
        }

        City deliveryCity = session.find(City.class, delivery_place);
        City returnCity = session.find(City.class, return_place);
        Vehicle vehicle = session.find(Vehicle.class, licence);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date deliveryDatetime = formatter.parse(delivery_date);
        Date returnDatetime = formatter.parse(return_date);

        long diffInMillies = Math.abs(returnDatetime.getTime() - deliveryDatetime.getTime());
        int rentDuration = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        Rental rent = new Rental(vehicle, client, deliveryCity, returnCity, deliveryDatetime, returnDatetime, cost * rentDuration);
        session.save(rent);
        tx.commit();
        session.close();

        return rent;
    }

    public Response remove(String id) {
        try {
            Rental rental = session.find(Rental.class, id);

            if(rental == null) {
                throw new DataNotFoundException("Rental not found");
            }

            session.delete(rental);
            tx.commit();
            SuccessMessage successMessage = new SuccessMessage("rental deleted successfully");
            return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK)
                    .entity(successMessage)
                    .build();
        } catch (Throwable e) {
            throw new GenericException("Unknown Error");
        }  finally {
            session.close();
        }
    }
}
