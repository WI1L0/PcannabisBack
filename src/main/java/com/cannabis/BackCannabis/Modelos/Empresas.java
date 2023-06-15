package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresas")
    private Integer idEmpresas;

    @Column(name = "nombreEmp")
    private String nombreEmp;

    @Column(name = "historia")
    private String historia;

    @Column(name = "mision")
    private String mision;

    @Column(name = "vision")
    private String vision;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "valor1")
    private String valor1;

    @Column(name = "valor2")
    private String valor2;

    @Column(name = "valor3")
    private String valor3;

    @Column(name = "valor4")
    private String valor4;

    @Column(name = "valor5")
    private String valor5;

    @Column(name = "valor6")
    private String valor6;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "estEmpresas")
    private Boolean estEmpresas;

    //RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "empresas")
    private List<Beneficios> beneficios;

    @JsonIgnore
    @OneToMany(mappedBy = "empresas")
    private List<UsosAplicaciones> usosAplicaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "empresas")
    private List<Noticias> noticias;

    @JsonIgnore
    @OneToMany(mappedBy = "empresas")
    private List<Productos> productos;

    @JsonIgnore
    @OneToMany(mappedBy = "empresas")
    private List<Empleados> empleados;



}
