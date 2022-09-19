package com.benalibenabdesselam.eticketbackend.repositories;

import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.Ticket;
import com.benalibenabdesselam.eticketbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String>, PagingAndSortingRepository<Ticket, String> {

    @Query("select t from Ticket t where  t.demande  like :kw")
    List<Ticket> searchTicket(@Param("kw") String keyword);

    @Query("select t from Ticket t where t.client.user.id=:kw")
    List<Ticket> findTicketByClient(@Param("kw") Long id);


    void deleteTicketByReference(String reference);

   Ticket findByReference(String reference);
   // void deleteChatById(Long id);
}
