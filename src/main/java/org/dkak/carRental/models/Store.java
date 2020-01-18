package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.Path;

@Entity
@Table(name = "store")
@Path("store")
public class Store {
	
	@Id
	@Column(name="STORE_ID")
	private String id;
	@Column(name="STORE_NAME")
	private String name;		
	@ManyToOne
    @JoinColumn(name="CITY_ID", nullable=false)
    private City city;
		 
	public Store() {
		
	}

	public Store(String id, String name, City city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public void setName(String storeName) {
		this.name = storeName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
