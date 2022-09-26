package com.benalibenabdesselam.eticketbackend.Web;

import com.benalibenabdesselam.eticketbackend.model.Chat;
import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.Ticket;
import com.benalibenabdesselam.eticketbackend.model.User;
import com.benalibenabdesselam.eticketbackend.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketRestAPI {
   private final TicketService ticketService;




    @GetMapping("/myTicket/{id}")
    public ResponseEntity<List<Ticket>> getTicketByClient(@PathVariable("id") Long id){
        List<Ticket> tickets=ticketService.getTicketByClient(id);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }



    @GetMapping("/allTicket")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets=ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/findTicket/{reference}")
    public ResponseEntity<Ticket> getTicketByReference(@PathVariable("reference") String reference){
        Ticket ticket=ticketService.findByReference(reference);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/addTicket")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket newTicket=ticketService.addTicket(ticket);
       return new ResponseEntity<>(newTicket,HttpStatus.CREATED);
    }





    @PutMapping("/updateTicket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
       // Ticket newTicket=ticketService.updateTicket(ticket);
        this.ticketService.updateTicket(ticket);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }


    @DeleteMapping("/DeleteTicket/{reference}")
    public ResponseEntity<?> deleteTicket(@PathVariable("reference")String reference){
        ticketService.deleteTicket(reference);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
