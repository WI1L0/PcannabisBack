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
@Table(name = "fotosEmpresas")
public class FotosEmpresas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFotoEmpresa")
    private Long idFotoEmpresa;

    @Column(name = "fotoEmpresa")
    private String fotoEmpresa;

    @Column(name = "categoriaFotoEmpresa")
    private String categoriaFotoEmpresa;

    @Column(name = "estFotoEmpresa")
    private Boolean estFotoEmpresa;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRFE;

}
