package com.benalibenabdesselam.eticketbackend.services;

import com.benalibenabdesselam.eticketbackend.enums.TicketStatus;
import com.benalibenabdesselam.eticketbackend.exceptions.ticketNotfoundException;
import com.benalibenabdesselam.eticketbackend.model.Chat;
import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.Ticket;
import com.benalibenabdesselam.eticketbackend.model.User;
import com.benalibenabdesselam.eticketbackend.repositories.ChatRepository;
import com.benalibenabdesselam.eticketbackend.repositories.ClientRepository;
import com.benalibenabdesselam.eticketbackend.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

@Slf4j
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ChatRepository chatRepository;
    private final ClientRepository clientRepository;


public List<Ticket> getTicketByClient(Long id){
    return ticketRepository.findTicketByClient(id);
}

    public Ticket addTicket(Ticket ticket) {
         ticket.setReference(UUID.randomUUID().toString());
         ticket.setCreatedAt(new Date());
         ticket.setStatus(TicketStatus.CREATED);

         return ticketRepository.save(ticket);
    }

    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicket(Ticket ticket) {
        ticket.setUpdatedAt(new Date());
        return ticketRepository.save(ticket);
    }

    public Optional<Client> countTicket(Client client){
        return clientRepository.findTicketById(client.getId());
    }

    public Ticket findByReference(String reference) {
        return ticketRepository.findByReference(reference);
    }

    public void deleteTicket(String reference) {
        ticketRepository.deleteTicketByReference(reference);
    }


    public void AddChattoTicket(Chat chat, String ticketID) {
       Ticket ticket=findByReference(ticketID);
       chat.setChatTime(new Date());
       chat.setTicket(ticket);
       chatRepository.save(chat);


    }
    public void deleteChat(Long id) {
        chatRepository.deleteChatById(id);
    }
    public Chat updateChat(Chat chat) {
        return chatRepository.save(chat);
    }
}