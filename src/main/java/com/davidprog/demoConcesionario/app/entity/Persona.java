package com.davidprog.demoConcesionario.app.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//
@Entity
// Define el nombre de la tabla a utilizar
@Table(name = "Personas")
// Sirve para definir automaticamente los metodos de encapsulamiento (get y set) para ahorrar codigo
@Data
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;
    // Agregar uevo atributo "nombre" con un parametro de 50 (length)
    @Column(name = "nombre", length = 50)
    private String nombres;

    @Column(name = "apellido", length = 50)
    private String apellidos;

    @Column(name = "correo", length = 50)
    private String correos;

    @Column(name = "edad", length = 3)
    private int edades;

    @Temporal(TemporalType.TIMESTAMP) // Marcar la fecha y hora
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimientos;

    @Column(name = "direccion", length = 50)
    private String direcciones;

    @Column(name = "contrasenia", length = 50)
    private String contrasenias;

    @ManyToMany
    @JoinTable(name = "Personas_has_Roles",
            joinColumns = @JoinColumn(name = "Fk_idRol", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "Fk_idPersona", nullable = false))
    private List<Rol> listRoles;

}
