package com.benalibenabdesselam.eticketbackend.Web;

import com.benalibenabdesselam.eticketbackend.model.Chat;
import com.benalibenabdesselam.eticketbackend.model.Ticket;
import com.benalibenabdesselam.eticketbackend.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketRestAPI {
   private final TicketService ticketService;




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

    @PostMapping("/addChat/{reference}")
    public ResponseEntity<Chat> addChat(@RequestBody Chat chat,@PathVariable("reference")String reference){
       ticketService.AddChattoTicket(chat,reference);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
