package com.davidprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class PersonaDTO {
    private int id_persona;

    private String nombres;

    private String apellidos;

    private String correos;

    private int edades;

    private Date fecha_nacimientos;

    private String direcciones;

    private String contrasenias;
}
