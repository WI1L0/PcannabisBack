package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InfoProductosDtos {

    private Long idInfProducto;
    private String tituloInfProducto;
    private String descripcionInfProducto;
    private Boolean estInfProducto;

}
