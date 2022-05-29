package com.example.osmanguler.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String planeType;
    private int lameClassCapacity;
    private int firstClassCapacity;
    private boolean isAbroad;

    @OneToMany
    private List<Ticket> ticketList = new ArrayList<>();





    public Plane() {
    }

    public Plane(long id, String planeType, int lameClassCapacity, int firstClassCapacity, int capacity, List<Ticket> ticketList, boolean isAbroad) {
        this.id = id;
        this.planeType = planeType;
        this.lameClassCapacity = lameClassCapacity;
        this.firstClassCapacity= firstClassCapacity;
        this.isAbroad = isAbroad;
        this.ticketList = ticketList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public int getLameClassCapacity() {
        return lameClassCapacity;
    }

    public void setLameClassCapacity(int lameCapacity) {
        this.lameClassCapacity = lameCapacity;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }


    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public void setFirstClassCapacity(int firstClassCapacity) {
        this.firstClassCapacity = firstClassCapacity;
    }

    public boolean isAbroad() {
        return isAbroad;
    }

    public void setAbroad(boolean abroad) {
        isAbroad = abroad;
    }

    public void StartFoodService(Ticket ticket){
        System.out.println("Starting food service for passenger with ticket id : "+ticket.getId());
    }

}
