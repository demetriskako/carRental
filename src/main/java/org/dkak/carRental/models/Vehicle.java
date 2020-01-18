package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Path;

@Entity
@Table(name = "vehicle")
@Path("vehicle")
public class Vehicle {
	
	@Id
	@Column(name="VEHICLE_LICENCE_NO")
	private String vehicleLicenceNo;
	@Column(name="STORE_ID")
	private String storeId;
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;
	@Column(name="VEHICLE_FUEL")
	private String vehicleFuel;
	@Column(name="VEHICLE_CAPACITY")
	private String vehicleCapacity;
	@Column(name="VEHICLE_RENTAL_COST")
	private String vehicleRentalCost;
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	@Column(name="VEHICLE_SEAT_HEIGHT")
	private String vehicleSeatHeight;
	@Column(name="VEHICLE_LUGGAGE_SUPPORT")
	private String vehicleLuggageSupport;
	@Column(name="VEHICLE_SEAT_NO")
	private String vehicleSeatNo;
	@Column(name="VEHICLE_DOOR_NUMBER")
	private String vehicleDoorNumber;
	@Column(name="CITY_ID")
	private String cityId;
	@Column(name="CITY_NAME")
	private String cityName;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String vehicleLicenceNo, String storeId, String vehicleModel, String vehicleFuel,
			String vehicleCapacity, String vehicleRentalCost, String vehicleType, String vehicleSeatHeight,
			String vehicleLuggageSupport, String vehicleSeatNo, String vehicleDoorNumber, String cityId,
			String cityName) {
		super();
		this.vehicleLicenceNo = vehicleLicenceNo;
		this.storeId = storeId;
		this.vehicleModel = vehicleModel;
		this.vehicleFuel = vehicleFuel;
		this.vehicleCapacity = vehicleCapacity;
		this.vehicleRentalCost = vehicleRentalCost;
		this.vehicleType = vehicleType;
		this.vehicleSeatHeight = vehicleSeatHeight;
		this.vehicleLuggageSupport = vehicleLuggageSupport;
		this.vehicleSeatNo = vehicleSeatNo;
		this.vehicleDoorNumber = vehicleDoorNumber;
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public String getVehicleLicenceNo() {
		return vehicleLicenceNo;
	}

	public void setVehicleLicenceNo(String vehicleLicenceNo) {
		this.vehicleLicenceNo = vehicleLicenceNo;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleFuel() {
		return vehicleFuel;
	}

	public void setVehicleFuel(String vehicleFuel) {
		this.vehicleFuel = vehicleFuel;
	}

	public String getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(String vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	public String getVehicleRentalCost() {
		return vehicleRentalCost;
	}

	public void setVehicleRentalCost(String vehicleRentalCost) {
		this.vehicleRentalCost = vehicleRentalCost;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleSeatHeight() {
		return vehicleSeatHeight;
	}

	public void setVehicleSeatHeight(String vehicleSeatHeight) {
		this.vehicleSeatHeight = vehicleSeatHeight;
	}

	public String getVehicleLuggageSupport() {
		return vehicleLuggageSupport;
	}

	public void setVehicleLuggageSupport(String vehicleLuggageSupport) {
		this.vehicleLuggageSupport = vehicleLuggageSupport;
	}

	public String getVehicleSeatNo() {
		return vehicleSeatNo;
	}

	public void setVehicleSeatNo(String vehicleSeatNo) {
		this.vehicleSeatNo = vehicleSeatNo;
	}

	public String getVehicleDoorNumber() {
		return vehicleDoorNumber;
	}

	public void setVehicleDoorNumber(String vehicleDoorNumber) {
		this.vehicleDoorNumber = vehicleDoorNumber;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	
}
