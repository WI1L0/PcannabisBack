package com.cannabis.BackCannabis.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "empresas")
public class Empresas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Long idEmpresa;

    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;

    @Column(name = "telefonoEmpresa")
    private String telefonoEmpresa;

    @Column(name = "direccionEmpresa")
    private String direccionEmpresa;

    @Column(name = "urlDireccionEmpresa")
    private String urlDireccionEmpresa;

    @Column(name = "urlDireccionEmpresaGoogle")
    private String urlDireccionEmpresaGoogle;

    @Column(name = "emailEmpresa")
    private String emailEmpresa;

    @Column(name = "celularEmpresa")
    private String celularEmpresa;

    @Column(name = "urlCelularEmpresa")
    private String urlCelularEmpresa;

    @Column(name = "estEmpresa")
    private Boolean estEmpresa;

    //RELACIONES
    @JsonBackReference
    @OneToMany(mappedBy = "empresasRU", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuarios> usuariosSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "empresasRFE", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FotosEmpresas> fotosEmpresasSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "empresasRN", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Noticias> noticiasSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "empresasRP", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Productos> productosSet = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "empresasRC", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contactanos> contactanosSet = new HashSet<>();

}
