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
public class CaracteristicaProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaracteristicaProductos")
    private Integer idCaracteristicaProductos;

    @Column(name = "tituloProductos")
    private String tituloProducto;

    @Column(name = "descripcionProductos")
    private String descripcionProductos;

    @Column(name = "estProductos")
    private Boolean estProductos;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idProducto",referencedColumnName ="idProducto")
    private Productos productos;

}
