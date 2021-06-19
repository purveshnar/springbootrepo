package com.purvesh.springboot.service;

import com.purvesh.springboot.model.LoginRequest;
import com.purvesh.springboot.model.RegisterUserRequest;
import com.purvesh.springboot.persistence.User;
import com.purvesh.springboot.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Registers the user
     *
     * @param registerUserRequest the request containing user information
     * @return registered user
     */
    public User registerUser(RegisterUserRequest registerUserRequest) {
        return userRepository.save(toUserModel().apply(registerUserRequest));
    }

    /**
     * Logs in the user
     *
     * @param loginRequest the login request
     */
    public void login(LoginRequest loginRequest) {

    }

    /**
     * Lambda to convert model to entity
     *
     * @return lambda performing the action
     */
    private Function<RegisterUserRequest, User> toUserModel() {
        return request -> User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
