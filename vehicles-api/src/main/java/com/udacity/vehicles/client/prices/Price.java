package com.udacity.vehicles.client.prices;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_Id")
    private Long vehicle_Id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price")
    private BigDecimal price;



    public Price() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicle_Id;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicle_Id = vehicleId;
    }
}
