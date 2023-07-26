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

public class ProductosReservasDtos {

    private Long idProductoReservas;
    private Integer cantidadProductoReservas;
    private Double precioProductoReservas;
    private Boolean estProductoReservas;

}
