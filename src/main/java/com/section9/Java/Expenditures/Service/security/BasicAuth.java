package com.section9.Java.Expenditures.Service.security;

import com.section9.Java.Expenditures.Service.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuth {
    // With spring security I can only use one default user to log in.
    // In 13th section of the course I will be adding more users.

    User user5 = new User(4,"Mateusz","Kuzera","qzera","q@q.com","pass");

    @GetMapping(value = "/basicauth")
    public User basicAuth(){
        return user5;
    }
}
