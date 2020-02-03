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

import org.dkak.carRental.models.City;
import org.dkak.carRental.services.CityService;

@Path("/cities")
public class CityResource {
	
	private CityService cityService = new CityService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> index() {
		return cityService.getAllCities();
	}
	
	@GET
	@Path("/{cityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public City findById(@PathParam("cityId") String id) {
		return cityService.getCity(id);
	}
	
	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("id") String id, @FormParam("name") String name) {
		City newCity = cityService.add(id, name);
		
		return Response.status(Status.CREATED)
				   .entity(newCity)
				   .build();	
	}
	
	@PUT 
	@Path("/{cityId}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("cityId") String id, @FormParam("name") String name) {
		City existingCity = cityService.update(id, name);
		
		return Response.status(Status.CREATED)
			   .entity(existingCity)
			   .build();
	}

	@DELETE
	@Path("/{cityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("cityId") String id) {
		return cityService.remove(id); 
	}
	
}
