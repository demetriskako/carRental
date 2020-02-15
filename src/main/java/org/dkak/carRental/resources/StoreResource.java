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

import org.dkak.carRental.models.Store;
import org.dkak.carRental.services.StoreService;

@Path("/stores")
public class StoreResource {
	private StoreService storeService;
	
	public StoreResource() {
		this.storeService = new StoreService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> index() {
		return storeService.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Store findById(@PathParam("id") String id) {
		return storeService.getStore(id);
	}

	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("id") String id, @FormParam("name") String name, @FormParam("city") String city) {
		Store newStore = storeService.add(id, name, city);

		return Response.status(Status.CREATED)
				   .entity(newStore)
				   .build();	
	}
	
	@PUT 
	@Path("/{id}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, @FormParam("name") String name, @FormParam("city") String city) {
		Store store = storeService.update(id, name, city);
		
		return Response.status(Status.CREATED)
			   .entity(store)
			   .build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") String id) {
		return storeService.remove(id); 
	}
}
