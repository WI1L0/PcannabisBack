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
@Table(name = "reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservas")
    private Integer idReservas;

    @Column(name = "fechaReservas")
    private LocalDate fechaReservas;

    @Column(name = "cantidadReservas")
    private Integer cantidadReservas;

    @Column(name = "estReservas")
    private Boolean estReservas;

    //RELACIONES
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "reservas_productos",
            joinColumns = @JoinColumn(name = "idProductos"),
            inverseJoinColumns = @JoinColumn(name = "idReservas")
    )
    private List<Productos> productos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="idUsuarios",referencedColumnName ="idUsuarios")
    private Usuarios usuarios;

}
