package com.benalibenabdesselam.eticketbackend.Web;

import com.benalibenabdesselam.eticketbackend.model.Client;
import com.benalibenabdesselam.eticketbackend.model.User;
import com.benalibenabdesselam.eticketbackend.repositories.UserRepository;
import com.benalibenabdesselam.eticketbackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")


public class UserRestAPI {
    private UserService userService;


    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser=userService.addUser(user);
        newUser.setRoles("USER");
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateClient(@RequestBody User user){
        User newUser=userService.updateUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
