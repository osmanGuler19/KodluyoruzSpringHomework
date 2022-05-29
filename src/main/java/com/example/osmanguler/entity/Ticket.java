package com.example.osmanguler.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String ticketType;
    private int price;
    private Date receiptDate;
    private long planeId;

    public long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(long planeId) {
        this.planeId = planeId;
    }

    public long getId() {
        return id;
    }

    public Ticket() {
    }

    public Ticket(long id, String ticketType, int price, Date receiptDate, int planeId) {
        this.id = id;
        this.ticketType = ticketType;
        this.price = price;
        this.receiptDate = receiptDate;
        this.planeId = planeId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

}
