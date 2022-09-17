package com.benalibenabdesselam.eticketbackend.services;

import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.User;
import com.benalibenabdesselam.eticketbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor

@Slf4j

public class UserService {
private UserRepository userRepository;

    public User addUser(User user){
        log.info("Saving new User");
        return userRepository.save(user);

    }
    public User findUserById(Long id){
        return userRepository.findUserById(id);

    }
    public List<User> findAllUsers(){
        return  userRepository.findAll();
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }


}
