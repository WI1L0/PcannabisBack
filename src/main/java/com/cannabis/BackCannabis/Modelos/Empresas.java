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
@Table(name = "Empresas")
public class Empresas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;

    @Column(name = "historia")
    private String historia;

    @Column(name = "mision")
    private String mision;

    @Column(name = "vision")
    private String vision;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "valores")
    private String valores;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "estEmpresa")
    private Boolean estEmpresa;

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
