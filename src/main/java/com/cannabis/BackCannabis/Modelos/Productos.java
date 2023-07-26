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
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "preDescripcionProducto")
    private String preDescripcionProducto;

    @Column(name = "descripcionProducto")
    private String descripcionProducto;

    @Column(name = "altoProducto")
    private Double altoProducto;

    @Column(name = "anchoProducto")
    private Double anchoProducto;

    @Column(name = "stockProducto")
    private Integer stockProducto;

    @Column(name = "modeloProducto")
    private String modeloProducto;

    @Column(name = "estProducto")
    private Boolean estProducto;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRP;

    @JsonBackReference
    @OneToMany(mappedBy = "productosRFP", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FotosProductos> fotosProductosSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "productos_categorias", joinColumns = @JoinColumn(name = "idProductoR", referencedColumnName = "idProducto"), inverseJoinColumns = @JoinColumn(name = "idCategoriasProductoR", referencedColumnName = "idCategoriasProducto"))
    private Set<CategoriasProductos> categoriasProductosSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "productosRIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InfoProductos> infProductoSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "productosRP", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductoReservas> productoReservasSet = new HashSet<>();

}
