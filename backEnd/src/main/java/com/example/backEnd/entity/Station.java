package com.example.backEnd.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table//(name = "station")
public class Station implements Serializable {
    
    private static final long serialVersionUID = 301L;
    
    @Id
    private int stationId;
    private int availableDrones;
    private int availableRobots;
    private String stationAddress;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ShippingOrder> shippingOrder;
    
    public int getStationId() { return stationId; }

    public void setStationId(int stationId) { this.stationId = stationId; }

    public int getAvailableDrones() { return availableDrones; }

    public void setAvailableDrones(int availableDrones) { this.availableDrones = availableDrones; }

    public int getAvailableRobots() { return availableRobots; }

    public void setAvailableRobots(int availableRobots) { this.availableRobots = availableRobots; }

    public List<ShippingOrder> getShippingOrder() { return shippingOrder; }

    public void setShippingOrder(List<ShippingOrder> shippingOrder) { this.shippingOrder = shippingOrder; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }
}
