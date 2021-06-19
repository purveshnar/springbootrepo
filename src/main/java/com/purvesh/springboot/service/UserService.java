package com.purvesh.springboot.service;

import com.purvesh.springboot.model.LoginDto;
import com.purvesh.springboot.model.RegisterUserDTO;
import com.purvesh.springboot.model.Users;
import com.purvesh.springboot.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Logs in the user
     *
     * @param loginDto the login request
     */
    public void login(LoginDto loginDto) {

    }
}
