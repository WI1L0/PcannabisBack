package com.cannabis.BackCannabis.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

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
    private Boolean estContactanos;

}
