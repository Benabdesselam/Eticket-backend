package com.benalibenabdesselam.eticketbackend.services;

import com.benalibenabdesselam.eticketbackend.exceptions.ClientNotFoundException;
import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    public Client addCLient(Client client){
        log.info("Saving new CLient");
        return clientRepository.save(client);

    }

    public Client findClientById(Long id){
        return clientRepository.findClientById(id);

    }
    public List<Client> findAllClients(){
        return  clientRepository.findAll();
    }
    public Client updateClient(Client client){
        return clientRepository.save(client);
    }
    public Client findClientByID(Long id){
        return clientRepository.findTicketById(id)
                .orElseThrow(()-> new ClientNotFoundException("Client by Id "+id+"was not found"));
    }

    public void deleteClient(Long id){
        clientRepository.deleteClientById(id);
    }
}
