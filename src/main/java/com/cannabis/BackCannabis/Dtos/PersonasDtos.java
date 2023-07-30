package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PersonasDtos {

    private Long idPersona;
    @NotEmpty(message = "La cedula no debe ser vacio")
    @NotNull(message = "La cedula no debe ser nulo")
    private String cedula;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private String referencia;
    private String celular;
    private LocalDate fNacimiento;
    private String genero;
    private String correo;
    private String barrio;
    private Boolean estPersona;

//    private UsuariosDtos usuariosDtos;

}
