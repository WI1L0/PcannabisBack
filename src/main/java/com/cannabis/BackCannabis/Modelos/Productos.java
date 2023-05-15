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
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "precioProducto")
    private String precioProducto;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "descripcionProducto")
    private String descripcionProducto;

    @Column(name = "stockProducto")
    private Integer stockProducto;

    @Column(name = "modeloProducto")
    private String modeloProducto;

    @Column(name = "estProducto")
    private Boolean estProducto;

    //RELACIONES
    @ManyToOne
    @JoinColumn(name="idEmpresa",referencedColumnName ="idEmpresa")
    private Empresas empresas;

    @JsonIgnore
    @OneToMany(mappedBy = "productos")
    private List<CaracteristicaProductos> caracteristicaProductos;

    @JsonIgnore
    @OneToMany(mappedBy = "productos")
    private List<FotoProductos> fotoProductos;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "productos_categoria",
            joinColumns = @JoinColumn(name = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "idCategoriaProductos")
    )
    private List<CategoriaProductos> categoriaProductos = new ArrayList<>();

    @ManyToMany(mappedBy = "productos")
    private List<Reserva> reservas = new ArrayList<>();

    //@ManyToMany(mappedBy = "productos")
    //private List<CategoriaProductos> categoriaProductos = new ArrayList<>();

}
