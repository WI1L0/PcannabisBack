package com.cannabis.BackCannabis.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contactanos")
public class Contactanos implements Serializable {

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

    @Column(name = "fechaContactanos")
    private LocalDate fechaContactanos;

    @Column(name = "estOcultoVisibleContactanos")
    private Boolean estOcultoVisibleContactanos;

    @Column(name = "estVisto")
    private Boolean estVisto;

    @Column(name = "estContactanos")
    private Boolean estContactanos;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresasR", nullable = false)
    private Empresas empresasRC;

}
