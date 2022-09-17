package com.benalibenabdesselam.eticketbackend.repositories;

import com.benalibenabdesselam.eticketbackend.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {


    List<Chat> findByTicketReference(String referance);

    void deleteChatById(Long id);
}
