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

public class UsuariosDtos {

    private Long idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
    private String fotoUsuario;
    private Boolean bloqueadoUsuario;
    private Boolean estUsuario;

    private PersonasDtos personas;

}
