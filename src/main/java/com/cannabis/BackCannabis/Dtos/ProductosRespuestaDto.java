package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductosRespuestaDto {

    private List<ProductosDtos> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPagina;
    private boolean ultima;

}
