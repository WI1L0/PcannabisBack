package com.cannabis.BackCannabis.excepciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogAppExeption extends RuntimeException{

    private HttpStatus estado;
    private String mensaje;

}
