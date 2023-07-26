package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NoticiasDtos {

    private Long idNoticia;
    private String tituloNoticia;
    private String preDescripcionNoticia;
    private LocalDate fechaNoticia;
    private String ubicacionNoticia;
    private String portadaNoticia;
    private Boolean estOcultoVisibleNoticia;
    private Boolean estNoticia;

}
