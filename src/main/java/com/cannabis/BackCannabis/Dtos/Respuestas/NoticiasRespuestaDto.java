package com.cannabis.BackCannabis.Dtos.Respuestas;

import com.cannabis.BackCannabis.Dtos.NoticiasDtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NoticiasRespuestaDto {

    private List<NoticiasDtos> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPagina;
    private boolean ultima;

}
