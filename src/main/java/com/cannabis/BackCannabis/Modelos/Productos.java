package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductos")
    private Integer idProductos;

    @Column(name = "precioProductos")
    private String precioProductos;

    @Column(name = "nombreProductos")
    private String nombreProductos;

    @Column(name = "descripcionProductos")
    private String descripcionProductos;

    @Column(name = "stockProductos")
    private Integer stockProductos;

    @Column(name = "modeloProductos")
    private String modeloProductos;

    @Column(name = "estProductos")
    private Boolean estProductos;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresas",referencedColumnName ="idEmpresas")
    private Empresas empresas;

    @JsonIgnore
    @OneToMany(mappedBy = "productos")
    private List<CaracteristicasProductos> caracteristicaProductos;

    @JsonIgnore
    @OneToMany(mappedBy = "productos")
    private List<FotosProductos> fotosProductos;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "idProductos"),
            inverseJoinColumns = @JoinColumn(name = "idCategoriasP")
    )
    private List<CategoriasProductos> categoriasProductos = new ArrayList<>();

    @ManyToMany(mappedBy = "productos")
    private List<Reservas> reservas = new ArrayList<>();

    //@ManyToMany(mappedBy = "productos")
    //private List<CategoriaProductos> categoriaProductos = new ArrayList<>();

}
