package org.dkak.carRental.models;

import javax.persistence.*;
import javax.ws.rs.Path;
import java.util.List;

@Entity
@Path("vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",
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
	@Column(name="VEHICLE_TYPE")
	private String vehicle_type;
	@Column(name="TYPE", insertable=false, updatable = false, nullable = false)
	private String type;
	@ManyToOne
    @JoinColumn(name="STORE_ID", nullable=false)
    private Store store;
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<Rental> rentals;
	
	public Vehicle() {

	}

	public Vehicle(String licence, String model, String fuel, String capacity, int cost, String type, String vehicle_type, Store store) {
		this.licence = licence;
		this.model = model;
		this.fuel = fuel;
		this.capacity = capacity;
		this.cost = cost;
		this.type = type;
		this.vehicle_type = vehicle_type;
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

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_type() {
		return vehicle_type;
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
