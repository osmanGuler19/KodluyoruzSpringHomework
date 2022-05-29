package com.example.osmanguler;

import com.example.osmanguler.entity.Flyer;
import com.example.osmanguler.entity.Plane;
import com.example.osmanguler.entity.Ticket;
import com.example.osmanguler.repository.FlyerRepository;
import com.example.osmanguler.repository.PlaneRepository;
import com.example.osmanguler.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@ComponentScan({"com.example.osmanguler.controller.TicketController"})
public class TicketApplication implements CommandLineRunner {

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private FlyerRepository flyerRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Plane plane = new Plane();
		plane.setFirstClassCapacity(20);
		plane.setLameClassCapacity(40);
		plane.setAbroad(true);
		plane.setPlaneType("THY");

		Flyer flyer = new Flyer();
		flyer.setAge(23);
		flyer.setName("Osman");
		flyer.setSex(1);

		Ticket ticket = new Ticket();
		ticket.setTicketType("firstclass");
		ticket.setPrice(500);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse("08/06/2022");
		ticket.setReceiptDate(date);
		ticket.setPlaneId(plane.getId());


		flyer.getTicketList().add(ticket);
		plane.getTicketList().add(ticket);

		ticketRepository.save(ticket);
		flyerRepository.save(flyer);
		planeRepository.save(plane);
	}
}
