package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productoReservas")
public class ProductoReservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductoReservas")
    private Long idProductoReservas;

    @Column(name = "cantidadProductoReservas")
    private Integer cantidadProductoReservas;

    @Column(name = "precioProductoReservas")
    private Double precioProductoReservas;

    @Column(name = "estProductoReservas")
    private Boolean estProductoReservas;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReservasR", nullable = false)
    private Reservas reservasRR;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductosR", nullable = false)
    private Productos productosRP;

}
