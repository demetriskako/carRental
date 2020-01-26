package org.dkak.carRental.resources;

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

import org.dkak.carRental.exceptions.GenericException;
import org.dkak.carRental.models.Car;
import org.dkak.carRental.models.TwoWheeled;
import org.dkak.carRental.models.Vehicle;
import org.dkak.carRental.services.CarService;
import org.dkak.carRental.services.TwoWheeledService;
import org.dkak.carRental.services.VehicleService;

@Path("/vehicles")
public class VehicleResource {

	private TwoWheeledService twoWheeledService = new TwoWheeledService();
	private CarService carService = new CarService();
	private VehicleService vehicleService = new VehicleService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> index() {
		return vehicleService.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle findById(@PathParam("id") String id) {
		return vehicleService.show(id);
	}
	
	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("licence") String licence, @FormParam("vehicle_type") String vehicle_type,
			@FormParam("model") String model, @FormParam("fuel") String fuel, @FormParam("cost") int cost, @FormParam("capacity") String capacity, @FormParam("store") String store,
			@FormParam("doors") int doors, @FormParam("seats") int seats,
			@FormParam("seatHeight") int seatHeight, @FormParam("luggage") String luggage) {

		if(vehicle_type.equals("Small Car") || vehicle_type.equals("Medium Car") || vehicle_type.equals("Big Car")) {
			Car car = carService.add(licence, vehicle_type, model, fuel, cost, capacity, store, doors, seats);
			
			return Response.status(Status.CREATED)
					.entity(car)
					.build();

		}else if(vehicle_type.equals("Scooter") || vehicle_type.equals("TwoWheeled")) {
			TwoWheeled twoWheeled = twoWheeledService.add(licence, vehicle_type, model, fuel, cost, capacity, store, seatHeight, luggage);
			
			return Response.status(Status.CREATED)
					.entity(twoWheeled)
					.build();	
		}

		throw new GenericException("Duplicate Entry!");
	}
//	
//	@PUT 
//	@Path("/{cityId}")
//	@Consumes("application/x-www-form-urlencoded")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response update(@PathParam("cityId") String id, @FormParam("name") String name) {
//		City existingCity = cityService.update(id, name);
//		
//		return Response.status(Status.CREATED)
//			   .entity(existingCity)
//			   .build();
//	}
//
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") String id) {
		return vehicleService.remove(id);
	}
}
