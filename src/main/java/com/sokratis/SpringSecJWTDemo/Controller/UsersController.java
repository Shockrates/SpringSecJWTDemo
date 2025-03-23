package com.sokratis.SpringSecJWTDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sokratis.SpringSecJWTDemo.Models.Users;
import com.sokratis.SpringSecJWTDemo.Service.UsersService;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){

        return usersService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        System.out.println(user);
        return usersService.verify(user);
    }

}
