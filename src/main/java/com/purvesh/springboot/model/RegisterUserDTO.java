package com.purvesh.springboot.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterUserDTO {
    @NotBlank(message = "Email cannot be blank")
    @Length(max = 40)
    @Valid
    String email;
    @NotBlank(message = "Name cannot be blank")
    @Length(max = 40)
    @Valid
    String name;
    @NotBlank(message = "password cannot be blank")
    @Length(min = 3, max = 45)
    @Valid
    String password;
}
