package com.purvesh.springboot.controller;

import com.purvesh.springboot.model.RegisterUserDTO;
import com.purvesh.springboot.service.UserService;
import com.purvesh.springboot.util.EntitiyHawk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController extends EntitiyHawk {

    @Autowired
    UserService userService;
}
