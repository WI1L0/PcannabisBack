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
@Table(name = "infProducto")
public class InfoProductos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInfProducto")
    private Long idInfProducto;

    @Column(name = "tituloInfProducto")
    private String tituloInfProducto;

    @Column(name = "descripcionInfProducto")
    private String descripcionInfProducto;

    @Column(name = "estInfProducto")
    private Boolean estInfProducto;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductoR", nullable = false)
    private Productos productosRIP;

}
