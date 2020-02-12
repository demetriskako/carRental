package org.dkak.carRental.controllers;

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

import org.dkak.carRental.models.Client;
import org.dkak.carRental.services.ClientService;

@Path("/clients")
public class ClientController {
	
	private ClientService clientService;
	
	public ClientController() {
		this.clientService = new ClientService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> index() {
		return clientService.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client findById(@PathParam("id") String id) {
		return clientService.show(id);
	}

	@POST
	@Path("/create")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("id") String id, @FormParam("name") String name, @FormParam("surname") String surname, @FormParam("license") String license,
			@FormParam("email") String email, @FormParam("tel") String tel, @FormParam("address") String address) {
		Client client = clientService.create(id, name, surname, license, email, tel, address);

		return Response.status(Status.CREATED)
				   .entity(client)
				   .build();	
	}
	
	@PUT 
	@Path("/{id}")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, @FormParam("id") String newId, @FormParam("name") String name, @FormParam("surname") String surname, @FormParam("license") String license,
			@FormParam("email") String email, @FormParam("tel") String tel, @FormParam("address") String address) {
		Client client = clientService.update(id, newId, name, surname, license, email, tel, address);
		
		return Response.status(Status.CREATED)
			   .entity(client)
			   .build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") String id) {
		return clientService.remove(id); 
	}
}
