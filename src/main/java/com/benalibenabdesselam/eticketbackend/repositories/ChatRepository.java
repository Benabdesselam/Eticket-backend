package com.benalibenabdesselam.eticketbackend.repositories;

import com.benalibenabdesselam.eticketbackend.model.Chat;
import com.benalibenabdesselam.eticketbackend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {


}
