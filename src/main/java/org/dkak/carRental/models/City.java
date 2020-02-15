package org.dkak.carRental.models;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.ws.rs.Path;

@Entity
@Table(name = "city")
@Path("city")
public class City {
	
	@Id
	@Column(name="CITY_ID")
	private String id;
	@Column(name="CITY_NAME")
	private String name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
	@JsonbTransient	
	private List<Store> stores;

	public City() {
	}
	
	public City(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Store> getStores() {
		return stores;
	}
	
}
