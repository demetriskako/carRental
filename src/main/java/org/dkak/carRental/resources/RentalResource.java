package org.dkak.carRental.resources;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dkak.carRental.models.Rental;
import org.dkak.carRental.models.Store;
import org.dkak.carRental.services.RentalService;
import org.dkak.carRental.services.StoreService;

@Path("/rental")
public class RentalResource {
    private RentalService rentalService = new RentalService();

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rental> index() {
        return rentalService.search();
    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Store findById(@PathParam("id") String id) {
//        return storeService.getStore(id);
//    }

    @POST
    @Path("/create")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormParam("licence") String licence, @FormParam("delivery_place") String delivery_place,
                           @FormParam("delivery_date") String delivery_date, @FormParam("return_place") String return_place,
                           @FormParam("return_date") String return_date, @FormParam("client") String client,
                           @FormParam("cost") int cost, @FormParam("clientID") String clientID, @FormParam("name") String name, @FormParam("surname") String surname,
                           @FormParam("drivingLicense") String drivingLicense, @FormParam("email") String email,
                           @FormParam("address") String address, @FormParam("tel") String tel) throws ParseException {

        //if new customer Create customer
        //Create Rental
        Rental rental = rentalService.add(licence, delivery_place, delivery_date,
                return_place, return_date, client, cost, clientID, name, surname, licence, email, tel, address);

        return Response.status(Status.CREATED)
                .entity(rental)
                .build();
    }

//    @PUT
//    @Path("/{id}")
//    @Consumes("application/x-www-form-urlencoded")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("id") String id, @FormParam("name") String name, @FormParam("city") String city) {
//        Store store = storeService.update(id, name, city);
//
//        return Response.status(Status.CREATED)
//                .entity(store)
//                .build();
//    }
//
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") String id) {
        return rentalService.remove(id);
    }
}
