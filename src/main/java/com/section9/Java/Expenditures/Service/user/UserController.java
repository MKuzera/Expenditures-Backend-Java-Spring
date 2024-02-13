package com.section9.Java.Expenditures.Service.user;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value="/{userID}")
    public User getUser(@PathVariable Integer userID){
        return userRepository.findUserById();
    }
    @GetMapping(value="/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    // add @Valid
    @PostMapping(value = "/addUser")
    public void  addUser(@RequestBody User user){
        User user1 = userRepository.save(user);

    }



}
