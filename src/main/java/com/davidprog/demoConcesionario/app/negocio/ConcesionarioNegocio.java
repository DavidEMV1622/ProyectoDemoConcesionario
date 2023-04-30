package com.davidprog.demoConcesionario.app.negocio;

import com.davidprog.demoConcesionario.app.dto.ConcesionarioDTO;
import com.davidprog.demoConcesionario.app.entity.Concesionario;
import com.davidprog.demoConcesionario.app.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {

    @Autowired
    private ConcesionarioImpl concesionarioImpl;

    private List<ConcesionarioDTO> listDTOConcesionario;

    public List<ConcesionarioDTO> encontrarTodos() {
        listDTOConcesionario = new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario -> {
            ConcesionarioDTO concesionarioDTO = new ConcesionarioDTO();
            concesionarioDTO.setId_concesionario(concesionario.getId_concesionario());
            concesionarioDTO.setNombres(concesionario.getNombres());
            concesionarioDTO.setDirecciones(concesionario.getDirecciones());
            concesionarioDTO.setCorreos(concesionario.getCorreos());
            concesionarioDTO.setTelefonos(concesionario.getTelefonos());
            this.listDTOConcesionario.add(concesionarioDTO);
        });
        return this.listDTOConcesionario;
    }

    public String crerConcesionario(ConcesionarioDTO concesionarioDTO) {
        Concesionario concesionario = new Concesionario();
        try{
            if (concesionarioDTO.getId_concesionario() != 0) {
                concesionario.setId_concesionario(concesionarioDTO.getId_concesionario());
                concesionario.setNombres(concesionarioDTO.getNombres());
                concesionario.setDirecciones(concesionarioDTO.getDirecciones());
                concesionario.setCorreos(concesionarioDTO.getCorreos());
                concesionario.setTelefonos(concesionarioDTO.getTelefonos());
                this.concesionarioImpl.actualizarConcesionario(concesionario);

            } else {
                concesionario.setNombres(concesionarioDTO.getNombres());
                concesionario.setDirecciones(concesionarioDTO.getDirecciones());
                concesionario.setCorreos(concesionarioDTO.getCorreos());
                concesionario.setTelefonos(concesionarioDTO.getTelefonos());
                this.concesionarioImpl.crearConcesionario(concesionario);
            }
            return "Se guardo los datos correctamente";
        } catch (Exception e) {
            return "Fallo algo";
        }
    }
}
