package org.dkak.carRental.models;

import org.joda.time.DateTime;

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
    private Vehicle licence;
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    private Client clientId;
    @ManyToOne
    @JoinColumn(name="RENTAL_PICKUP_LOCATION")
    private City pickupLocation;
    @ManyToOne
    @JoinColumn(name="RENTAL_RETURN_LOCATION")
    private City returnLocation;
    @Column(name="RENTAL_PICKUP_DATETIME")
    private Date pickupDatetime;
    @Column(name="RENTAL_RETURN_DATETIME")
    private Date returnDatetime;
    @Column(name="RENTAL_TOTAL_COST", insertable=true, updatable = false, nullable = false)
    private int totalCost;

    public Rental() {
    }

    public Rental(Vehicle licence, Client clientId, City pickupLocation, City returnLocation, Date pickupDatetime, Date returnDatetime, int totalCost) {
        this.licence = licence;
        this.clientId = clientId;
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

    public Vehicle getLicence() {
        return licence;
    }

    public void setLicence(Car licence) {
        this.licence = licence;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public City getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(City pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public City getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(City returnLocation) {
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
