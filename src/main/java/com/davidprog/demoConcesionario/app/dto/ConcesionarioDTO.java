package com.davidprog.demoConcesionario.app.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConcesionarioDTO {

    private int id_concesionario;

    private String nombres;

    private String direcciones;

    private String correos;

    private int telefonos;
}
