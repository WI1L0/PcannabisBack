package com.cannabis.BackCannabis.Dtos.Defauld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetallesDto {

    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;

}
