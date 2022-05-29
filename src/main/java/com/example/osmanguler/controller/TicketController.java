package com.example.osmanguler.controller;


import com.example.osmanguler.entity.Plane;
import com.example.osmanguler.entity.Ticket;
import com.example.osmanguler.repository.PlaneRepository;
import com.example.osmanguler.repository.TicketRepository;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/ticketService/v1")
public class TicketController implements ErrorController {
    private TicketRepository ticketRepository;
    private PlaneRepository planeRepository;
    @PostMapping("/takeTicket")
    public void takeTicket(@RequestBody Ticket ticket){
        ticketRepository.save(ticket);
        if(ticket.getTicketType().equalsIgnoreCase("firstclass")){
            Plane plane = planeRepository.findById(ticket.getPlaneId()).orElseThrow(NoSuchElementException::new);
            if(plane.isAbroad()){
                plane.StartFoodService(ticket);
            }

        }

    }

    @DeleteMapping("/returnTicket")
    public void returnTicket(@RequestBody Ticket ticket) throws Exception {
        ticketRepository.findById(ticket.getId()).orElseThrow(NoSuchElementException::new);
        Date now = new Date();
        long diffInMillies = Math.abs(now.getTime() - ticket.getReceiptDate().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if(diff<=3){
            ticketRepository.delete(ticket);
        }
        else{
            throw new Exception("You can't return your ticket because 3 day time is expired");
        }
    }

    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        return "<center><h1>Something went wrong</h1></center>";
    }
}
