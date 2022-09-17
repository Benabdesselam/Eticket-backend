package com.benalibenabdesselam.eticketbackend.Web;

import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.Ticket;
import com.benalibenabdesselam.eticketbackend.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/client")
@CrossOrigin("*")

public class ClientRestAPI {
    private final ClientService clientService;

    @GetMapping("/allClient")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients=clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/findClient/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id")Long id){
        Client client=clientService.findClientByID(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient=clientService.addCLient(client);
        return new ResponseEntity<>(newClient,HttpStatus.CREATED);
    }

    @PutMapping("/updateClient")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client newClient=clientService.updateClient(client);
        return new ResponseEntity<>(newClient,HttpStatus.OK);
    }

    @DeleteMapping("/DeleteClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id")Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
