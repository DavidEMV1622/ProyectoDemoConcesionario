package com.davidprog.demoConcesionario.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
//import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name = "nombre")
    private String nombres;

    @ManyToMany(mappedBy = "listRoles")
    private List<Persona> listPersonas;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_id_rol")
    private List<Venta> ventas;
}
