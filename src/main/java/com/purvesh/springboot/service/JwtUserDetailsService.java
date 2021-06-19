package com.purvesh.springboot.service;

import com.purvesh.springboot.model.RegisterUserDTO;
import com.purvesh.springboot.model.Users;
import com.purvesh.springboot.persistence.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("username@email.com".equals(username)) {
            return new User("username@email.com", "$2a$10$JmEqHJ1ZGpvssKqBmP8x3uFGB1c4gKS3Bs7UT3fw1uZAjD8WrD/3a",
                    new ArrayList<>());
        } else {
            log.error("User not found with username: " + username);
            throw new BadCredentialsException("Invalid Username or Password");
        }
    }

    /**
     * Registers the user
     *
     * @param registerUserDTO the request containing user information
     * @return registered user
     */
    public Users registerUser(RegisterUserDTO registerUserDTO) {
        return userRepository.save(toUsersEntity().apply(registerUserDTO));
    }

    /**
     * Lambda to convert model to entity
     *
     * @return lambda performing the action
     */
    public Function<RegisterUserDTO, Users> toUsersEntity() {
        return request -> Users.builder()
                .userName(request.getName())
                .email(request.getEmail())
                .password(bcryptEncoder.encode(request.getPassword()))
                .build();
    }

}