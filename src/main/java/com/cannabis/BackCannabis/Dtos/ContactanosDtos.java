package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ContactanosDtos {

    private Long idContactanos;
    private String nombreContactanos;
    private String celularContactanos;
    private String emailContactanos;
    private String asuntoContactanos;
    private String detalleContactanos;
    private LocalDate fechaContactanos;
    private Boolean estOcultoVisibleContactanos;
    private Boolean estVisto;
    private Boolean estContactanos;

}
