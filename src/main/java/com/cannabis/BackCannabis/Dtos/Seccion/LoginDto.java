package com.cannabis.BackCannabis.Dtos.Seccion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginDto {

    private String usernameOrEmail;
    private String password;

}