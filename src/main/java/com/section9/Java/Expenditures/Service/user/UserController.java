package com.section9.Java.Expenditures.Service.user;

import com.section9.Java.Expenditures.Service.Expenditures.Expenditure;
import org.springframework.web.bind.annotation.*;
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

    @Deprecated // switched to BasicAuth
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody LoginRequest loginRequest) {
        return userService.LoginUser(loginRequest.getLogin(), loginRequest.getPassword());
    }
    @GetMapping(value="/usergetid/{userlogin}")
    public Integer getUserID(@PathVariable String userlogin){
        return userService.getUserByLogin(userlogin).getId();
    }


}
