package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caracteristicasProductos")
public class CaracteristicasProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaracteristicasP")
    private Integer idCaracteristicasP;

    @Column(name = "tituloCaracteristicasP")
    private String tituloCaracteristicasP;

    @Column(name = "descripcionCaracteristicasP")
    private String descripcionCaracteristicasP;

    @Column(name = "estCaracteristicasP")
    private Boolean estCaracteristicasP;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idProductos",referencedColumnName ="idProductos")
    private Productos productos;

}
