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

public class EmpresasDtos {

    private Long idEmpresa;
    private String nombreEmpresa;
    private String telefonoEmpresa;
    private String direccionEmpresa;
    private String urlDireccionEmpresa;
    private String celularEmpresa;
    private String urlCelularEmpresa;
    private String urlDireccionEmpresaGoogle;
    private String emailEmpresa;
    private Boolean estEmpresa;

}
