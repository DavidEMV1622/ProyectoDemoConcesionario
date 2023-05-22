package com.davidprog.demoConcesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@Component
public class RolDTO {

    private int id_rol;

    private String nombres;
}