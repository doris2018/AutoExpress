package com.example.backEnd.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;
@Entity
@Table//(name = "shippingorder")
public class ShippingOrder implements Serializable {
    // Let's assume one user can create many salesOrder
    // currently, there are now historical salesorders
    //historical model will be implemented with a historical table later.
    private static final long serialVersionUID = 201L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    private Customer customer;
    private String senderAddress;
    private String receiverAddress;
    private String receiverName;
    private String cardNumber;
    private String size; // small, medium, large
    private double weight;
    private String description;
    private String deliveryMethod; // robot, drone
    private double fee;
    private String status; // waiting, ongoing, finished
    private Timestamp time;

    @ManyToOne
    private Station station; // == FK station_id
    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getSenderAddress() { return senderAddress; }

    public void setSenderAddress(String senderAddress) { this.senderAddress = senderAddress; }

    public String getReceiverAddress() { return receiverAddress; }

    public void setReceiverAddress(String receiverAddress) { this.receiverAddress = receiverAddress; }

    public String getReceiverName() { return receiverName; }

    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getCardNumber() { return cardNumber; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getDeliveryMethod() { return deliveryMethod; }

    public void setDeliveryMethod(String deliveryMethod) { this.deliveryMethod = deliveryMethod; }

    public double getFee() { return fee; }

    public void setFee(double fee) { this.fee = fee; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Timestamp getTime() { return time; }

    public void setTime(Timestamp time) { this.time = time; }

    public Station getStation() { return station; }

    public void setStation(Station station) { this.station = station; }

}
