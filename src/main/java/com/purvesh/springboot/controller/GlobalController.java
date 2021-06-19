package com.purvesh.springboot.controller;

import com.purvesh.springboot.model.JwtResponse;
import com.purvesh.springboot.model.LoginDto;
import com.purvesh.springboot.model.RegisterUserDTO;
import com.purvesh.springboot.model.Users;
import com.purvesh.springboot.service.JwtUserDetailsService;
import com.purvesh.springboot.util.EntitiyHawk;
import com.purvesh.springboot.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class GlobalController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        authenticate(loginDto.getEmail(), loginDto.getPassword());
        String token = jwtUtils.generateToken(jwtUserDetailsService.loadUserByUsername(loginDto.getEmail()));
        return new EntitiyHawk().genericSuccess(token);
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity registerUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        Users users = jwtUserDetailsService.registerUser(registerUserDTO);
        return new EntitiyHawk().genericSuccess("User Registered");

    }

    private void authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }
}
