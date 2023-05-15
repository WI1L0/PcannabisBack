package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoriaProductos")
public class CategoriaProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaProductos")
    private Integer idCategoriaProductos;

    @Column(name = "nombreCategoriaProductos")
    private String nombreCategoriaProductos;

    @Column(name = "descripcionCategoriaProductos")
    private String descripcionCategoriaProductos;

    @Column(name = "estCategoriaProductos")
    private Boolean estCategoriaProductos;

    //RELACIONES
    @ManyToMany(mappedBy = "categoriaProductos")
    private List<Productos> productos = new ArrayList<>();

}
