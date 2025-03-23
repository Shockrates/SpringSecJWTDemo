package com.sokratis.SpringSecJWTDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sokratis.SpringSecJWTDemo.Models.Users;
import com.sokratis.SpringSecJWTDemo.Repository.UserRepo;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTService jtwService;

    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jtwService.generateToken(user.getUsername());
        }
        return "Failed to Login";
    }

}
