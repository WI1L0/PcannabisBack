package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long idReserva;

    @Column(name = "fechaReserva")
    private LocalDate fechaReserva;

    @Column(name = "totalReserva")
    private Double totalReserva;

    @Column(name = "estReserva")
    private Boolean estReserva;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarioR", nullable = false)
    private Usuarios usuariosRR;


    @JsonBackReference
    @OneToMany(mappedBy = "reservasRR", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductoReservas> productoReservasSet = new HashSet<>();

}
