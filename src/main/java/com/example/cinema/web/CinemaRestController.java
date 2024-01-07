package com.example.cinema.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import com.example.dao.FilmRepository;
import com.example.dao.TicketRepository;
import com.example.entities.*;
import com.example.entities.Ticket;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin("*") // ajouter
public class CinemaRestController {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private FilmRepository filmRepository;
	@GetMapping(path="/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte [] image (@PathVariable (name = "id")Long id) throws Exception{
		Film f = filmRepository.findById(id).get();
		String photoName= f.getPhoto();
		File file = new File(System.getProperty("user.home")+"/cinema/images"+photoName+".jpg");
		Path path = Paths.get(file.toURI());
		return Files.readAllBytes(path);
		
		}
	

	@PostMapping("/payerTickets")
	@Transactional // hadi tzadet
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
		List<Ticket> listTickets = new ArrayList<>();
		ticketForm.getTickets().forEach(idTicket->{
			Ticket ticket = ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReservee(true);
			ticketRepository.save(ticket);
		});
		return listTickets;
	}
}

@Data
class TicketForm{
	public List<Long> getTickets() {
		return tickets;
	}
	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	private List<Long> tickets = new ArrayList<>();
	private String nomClient;
}
	
