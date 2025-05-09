package com.sokratis.SpringSecJWTDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.sokratis.SpringSecJWTDemo.Models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

    Users findByUsername(String username);

}
