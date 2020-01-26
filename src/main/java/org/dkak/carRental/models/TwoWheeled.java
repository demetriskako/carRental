package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TwoWheeled")
public class TwoWheeled extends Vehicle {

	@Column(name="VEHICLE_SEAT_HEIGHT")
	private int seatHeight;
	@Column(name="VEHICLE_LUGGAGE_SUPPORT")
	private String luggage;
	
	public TwoWheeled() {

	}

	public TwoWheeled(String license, String model, String fuel, String capacity, int cost, String type, String vehicle_type, Store store, int seatHeight, String luggage) {
		super(license, model, fuel, capacity, cost, type, vehicle_type, store);
		
		this.seatHeight = seatHeight;
		this.luggage = luggage;
	}

	public int getSeatHeight() {
		return seatHeight;
	}

	public void setSeatHeight(int seatHeight) {
		this.seatHeight = seatHeight;
	}

	public String getLuggage() {
		return luggage;
	}

	public void setLuggage(String luggage) {
		this.luggage = luggage;
	}
}
