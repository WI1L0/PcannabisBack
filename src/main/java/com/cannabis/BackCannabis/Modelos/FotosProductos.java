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
@Table(name = "fotosProductos")
public class FotosProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFotosProducto")
    private Long idFotosProducto;

    @Column(name = "fotosProducto")
    private String fotosProducto;

    @Column(name = "estFotosProducto")
    private Boolean estFotosProducto;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductoR", nullable = false)
    private Productos productosRFP;

}
