package com.benalibenabdesselam.eticketbackend.repositories;

import com.benalibenabdesselam.eticketbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("select c from Client c where c.email like :kw")
   List<Client> searchClient(@Param("kw") String keyword);

    Optional<Client> findTicketById(Long id);

    Client findClientByUserId(Long userId);

    void deleteClientById(Long id);

    Client findClientById(Long id);
}
