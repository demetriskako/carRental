package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.DiscriminatorType;
import javax.ws.rs.Path;

@Entity
@Path("vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE", 
  discriminatorType = DiscriminatorType.STRING)

public class Vehicle {
	
	@Id
	@Column(name="VEHICLE_LICENCE_NO")
	private String licence;
	@Column(name="VEHICLE_MODEL")
	private String model;
	@Column(name="VEHICLE_FUEL")
	private String fuel;
	@Column(name="VEHICLE_CAPACITY")
	private String capacity;
	@Column(name="VEHICLE_RENTAL_COST")
	private int cost;
	@Column(name="VEHICLE_TYPE", insertable=false, updatable = false, nullable = false)
	private String type;
	@ManyToOne
    @JoinColumn(name="STORE_ID", nullable=false)
    private Store store;
	
	public Vehicle() {

	}

	public Vehicle(String licence, String model, String fuel, String capacity, int cost, String type, Store store) {
		this.licence = licence;
		this.model = model;
		this.fuel = fuel;
		this.capacity = capacity;
		this.cost = cost;
		this.type = type;
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
