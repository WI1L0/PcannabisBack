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

public class ReservasDtos {

    private Long idReserva;
    private LocalDate fechaReserva;
    private Double totalReserva;
    private Boolean estReserva;

}
