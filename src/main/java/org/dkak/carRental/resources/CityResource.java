package org.dkak.carRental.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dkak.carRental.models.City;
import org.dkak.carRental.services.CityService;

@Path("/cities")
public class CityResource {
	
	CityService cityService = new CityService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getCities() {
		return cityService.getAllCities();
	}
	
}
