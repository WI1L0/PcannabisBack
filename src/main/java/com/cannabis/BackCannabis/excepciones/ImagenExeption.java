package com.cannabis.BackCannabis.excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ImagenExeption extends  RuntimeException{

    private String mensaje;

    public ImagenExeption(String mensaje) {
        super(String.format(mensaje));
        this.mensaje = mensaje;
    }

}
