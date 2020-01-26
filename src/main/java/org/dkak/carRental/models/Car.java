package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {
	@Column(name="VEHICLE_DOOR_NUMBER")
	private Integer doors;
	@Column(name="VEHICLE_SEAT_NO")
	private Integer seats;
	
	public Car() {
	}

	public Car(String license, String model, String fuel, String capacity, int cost, String type, String vehicle_type, Store store, Integer seats, Integer doors) {
		super(license, model, fuel, capacity, cost, type, vehicle_type, store);
		this.seats = seats;
		this.doors = doors;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
}
