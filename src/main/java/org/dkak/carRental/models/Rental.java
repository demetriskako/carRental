package org.dkak.carRental.models;

import javax.persistence.*;
import javax.ws.rs.Path;
import java.util.Date;

@Entity
@Table(name = "rental")
@Path("rental")
public class Rental {
    @Id
    @Column(name="RENTAL_ID")
    private int id;
    @ManyToOne
    @JoinColumn(name="VEHICLE_LICENCE_NO")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="RENTAL_PICKUP_LOCATION")
    private Store pickupLocation;
    @ManyToOne
    @JoinColumn(name="RENTAL_RETURN_LOCATION")
    private Store returnLocation;
    @Column(name="RENTAL_PICKUP_DATETIME")
    private Date pickupDatetime;
    @Column(name="RENTAL_RETURN_DATETIME")
    private Date returnDatetime;
    @Column(name="RENTAL_TOTAL_COST")
    private int totalCost;


    public Rental() {
    }

    public Rental(Vehicle vehicle, Client client, Store pickupLocation, Store returnLocation, Date pickupDatetime, Date returnDatetime, int totalCost) {
        this.vehicle = vehicle;
        this.client = client;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.pickupDatetime = pickupDatetime;
        this.returnDatetime = returnDatetime;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Store getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Store pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Store getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(Store returnLocation) {
        this.returnLocation = returnLocation;
    }

    public Date getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(Date pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public Date getReturnDatetime() {
        return returnDatetime;
    }

    public void setReturnDatetime(Date returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
