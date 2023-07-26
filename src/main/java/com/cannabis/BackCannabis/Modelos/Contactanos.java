package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contactanos")
public class Contactanos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContactanos")
    private Long idContactanos;

    @Column(name = "nombreContactanos")
    private String nombreContactanos;

    @Column(name = "celularContactanos")
    private String celularContactanos;

    @Column(name = "emailContactanos")
    private String emailContactanos;

    @Column(name = "asuntoContactanos")
    private String asuntoContactanos;

    @Column(name = "detalleContactanos")
    private String detalleContactanos;

    @Column(name = "estContactanos")
    private Boolean estContactanos;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRC;

}
