package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductosDtos {

    private Long idProducto;
    private String nombreProducto;
    private String preDescripcionProducto;
    private String descripcionProducto;
    private Double altoProducto;
    private Double anchoProducto;
    private Integer stockProducto;
    private String modeloProducto;
    private Boolean estProducto;

}
