package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FotosEmpresasDtos {

    private Long idFotoEmpresa;
    private String fotoEmpresa;
    private String categoriaFotoEmpresa;
    private Boolean estFotoEmpresa;

}
