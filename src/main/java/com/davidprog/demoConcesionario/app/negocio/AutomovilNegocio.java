package com.davidprog.demoConcesionario.app.negocio;

import com.davidprog.demoConcesionario.app.dto.AutomovilDTO;
import com.davidprog.demoConcesionario.app.entity.Automovil;
import com.davidprog.demoConcesionario.app.implementacion.Automovilimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutomovilNegocio {

    @Autowired
    private Automovilimpl automovilimpl;

    private List<AutomovilDTO> listDTOAutomovil;

    public List<AutomovilDTO> encontrarTodos() {
        listDTOAutomovil = new ArrayList<>();
        this.automovilimpl.encontrarTodos().forEach(automovil -> {
            AutomovilDTO automovilDTO = new AutomovilDTO();
            automovilDTO.setId_automovil(automovil.getId_automovil());
            automovilDTO.setMatriculas(automovil.getMatriculas());
            automovilDTO.setMarcas(automovil.getMarcas());
            automovilDTO.setModelos(automovil.getModelos());
            automovilDTO.setAnios(automovil.getAnios());
            automovilDTO.setColores(automovil.getColores());
            automovilDTO.setKilometrajes(automovil.getKilometrajes());
            automovilDTO.setCan_puertas(automovil.getCan_puertas());
            automovilDTO.setTipos_combustibles(automovil.getTipos_combustibles());
            automovilDTO.setCap_personas(automovil.getCap_personas());
            automovilDTO.setPrecios(automovil.getPrecios());
            this.listDTOAutomovil.add(automovilDTO);
        });
        return this.listDTOAutomovil;
    }

    public String crearAutomovil(AutomovilDTO automovilDTO) {
        Automovil automovil = new Automovil();
        try {
            if  (automovilDTO.getId_automovil() != 0) {
                automovil.setId_automovil(automovilDTO.getId_automovil());
                automovil.setMatriculas(automovilDTO.getMatriculas());
                automovil.setMarcas(automovilDTO.getMarcas());
                automovil.setModelos(automovilDTO.getModelos());
                automovil.setAnios(automovilDTO.getAnios());
                automovil.setColores(automovilDTO.getColores());
                automovil.setKilometrajes(automovilDTO.getKilometrajes());
                automovil.setCan_puertas(automovilDTO.getCan_puertas());
                automovil.setTipos_combustibles(automovilDTO.getTipos_combustibles());
                automovil.setCap_personas(automovilDTO.getCap_personas());
                automovil.setPrecios(automovilDTO.getPrecios());
                this.automovilimpl.actualizarAutomovil(automovil);

            } else {
                automovil.setMatriculas(automovilDTO.getMatriculas());
                automovil.setMarcas(automovilDTO.getMarcas());
                automovil.setModelos(automovilDTO.getModelos());
                automovil.setAnios(automovilDTO.getAnios());
                automovil.setColores(automovilDTO.getColores());
                automovil.setKilometrajes(automovilDTO.getKilometrajes());
                automovil.setCan_puertas(automovilDTO.getCan_puertas());
                automovil.setTipos_combustibles(automovilDTO.getTipos_combustibles());
                automovil.setCap_personas(automovilDTO.getCap_personas());
                automovil.setPrecios(automovilDTO.getPrecios());
                this.automovilimpl.crearAutomovil(automovil);
            }
            return "Se guardo los datos correctamente";
        } catch (Exception e) {
            return "Fallo algo";
        }
    }
}
