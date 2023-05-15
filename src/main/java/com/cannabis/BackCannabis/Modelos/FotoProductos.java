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
@Table(name = "fotoProductos")
public class FotoProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFotoProductos")
    private Integer idFotoProductos;

    @Column(name = "fotoProductos")
    private String fotoProductos;

    @Column(name = "estFotoProductos")
    private String stockProducto;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idProducto",referencedColumnName ="idProducto")
    private Productos productos;

}
