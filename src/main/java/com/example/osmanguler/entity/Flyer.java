package com.example.osmanguler.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int age;
    private int sex; // 0 for women, 1 for men

    @OneToMany
    private List<Ticket> ticketList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Flyer(long id, String name, int age, int sex, List<Ticket> ticketList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.ticketList = ticketList;
    }

    public Flyer() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }


}
