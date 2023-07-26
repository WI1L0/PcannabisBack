package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "personas")
public class Personas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long idPersona;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "celular")
    private String celular;

    @Column(name = "fNacimiento")
    private LocalDate fNacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "correo")
    private String correo;

    @Column(name = "estPersona")
    private Boolean estPersona;

    //RELACIONES
    @JsonBackReference
    @OneToMany(mappedBy = "personasRU", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuarios> usuariosSet = new HashSet<>();

}
