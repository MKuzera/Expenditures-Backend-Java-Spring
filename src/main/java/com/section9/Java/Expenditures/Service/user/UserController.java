package com.section9.Java.Expenditures.Service.user;

import com.section9.Java.Expenditures.Service.Expenditures.Expenditure;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
        userService.addRandom();
    }

    @GetMapping(value="/user/{userID}")
    public User getUser(@PathVariable Integer userID){
        return userService.getUserByIdFromDataBase(userID);
    }
    @GetMapping(value="/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    public void  addUser(@RequestBody User user){
        userService.saveUser(user);

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody LoginRequest loginRequest) {
        User user = userService.LoginUser(loginRequest.getLogin(), loginRequest.getPassword());
        return user;
    }



}
