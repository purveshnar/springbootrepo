package com.purvesh.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class RegisterUserRequest {

    private String fullName;
    private String email;
    private String password;
}
