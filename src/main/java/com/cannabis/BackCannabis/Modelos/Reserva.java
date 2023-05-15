package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer idReserva;

    @Column(name = "fechaReserva")
    private LocalDate fechaReserva;

    @Column(name = "cantidadReserva")
    private Integer cantidadReserva;

    @Column(name = "estReserva")
    private Boolean estReserva;

    //RELACIONES
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "pedido_productos",
            joinColumns = @JoinColumn(name = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "idReserva")
    )
    private List<Productos> productos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuarios usuarios;

}
