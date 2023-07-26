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
@Table(name = "parrafos")
public class Parrafos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParrafo")
    private Long idParrafo;

    @Column(name = "Parrafo")
    private String parrafo;

    @Column(name = "estParrafo")
    private Boolean estParrafo;

    //RELACIONES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNoticiasR", nullable = false)
    private Noticias noticiasRP;

}
