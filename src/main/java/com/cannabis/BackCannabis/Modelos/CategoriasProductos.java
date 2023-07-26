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
@Table(name = "categoriasProductos")
public class CategoriasProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriasProducto")
    private Long idCategoriasProducto;

    @Column(name = "nombreCategoriasProducto")
    private String nombreCategoriasProducto;

    @Column(name = "estCategoriasProducto")
    private Boolean estCategoriasProducto;

}
