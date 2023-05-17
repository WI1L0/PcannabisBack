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
    @Column(name = "idCategoriasP")
    private Integer idCategoriasP;

    @Column(name = "nombreCategoriasP")
    private String nombreCategoriasP;

    @Column(name = "descripcionCategoriasP")
    private String descripcionCategoriasP;

    @Column(name = "estCategoriasP")
    private Boolean estCategoriasP;

    //RELACIONES
    @ManyToMany(mappedBy = "categoriasProductos")
    private List<Productos> productos = new ArrayList<>();

}
