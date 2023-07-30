package com.cannabis.BackCannabis.Dtos.Respuestas;

import com.cannabis.BackCannabis.Dtos.PersonasDtos;
import com.cannabis.BackCannabis.Dtos.UsuariosDtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuariosRespuestaDto {

    private List<UsuariosDtos> contenidoUsuarios;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPagina;
    private boolean ultima;

}
