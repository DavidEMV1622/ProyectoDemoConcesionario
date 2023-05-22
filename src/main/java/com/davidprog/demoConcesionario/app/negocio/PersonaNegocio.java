package com.davidprog.demoConcesionario.app.negocio;

import com.davidprog.demoConcesionario.app.dto.PersonaDTO;
import com.davidprog.demoConcesionario.app.entity.Persona;
import com.davidprog.demoConcesionario.app.implementacion.PersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaNegocio {

    @Autowired
    private PersonaImpl personaImpl;

    private List<PersonaDTO> listDTOPersonas;

    public List<PersonaDTO> encontrarTodos() {
        listDTOPersonas = new ArrayList<>();
        this.personaImpl.encontrarTodos().forEach(persona->{
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setId_persona(persona.getId_persona());
            personaDTO.setNombres(persona.getNombres());
            personaDTO.setApellidos(persona.getApellidos());
            personaDTO.setCorreos(persona.getCorreos());
            personaDTO.setEdades(persona.getEdades());
            personaDTO.setFecha_nacimientos(persona.getFecha_nacimientos());
            personaDTO.setDirecciones(persona.getDirecciones());
            personaDTO.setContrasenias(persona.getContrasenias());
            this.listDTOPersonas.add(personaDTO);
        });
        return this.listDTOPersonas;
    }

    public String crearPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        try {
            if (personaDTO.getId_persona() != 0) {
                persona.setId_persona(personaDTO.getId_persona());
                persona.setNombres(personaDTO.getNombres());
                persona.setApellidos(personaDTO.getApellidos());
                persona.setCorreos(personaDTO.getCorreos());
                persona.setEdades(personaDTO.getEdades());
                persona.setFecha_nacimientos(personaDTO.getFecha_nacimientos());
                persona.setDirecciones(personaDTO.getDirecciones());
                persona.setContrasenias(personaDTO.getContrasenias());
                this.personaImpl.actualizarPersona(persona);

            } else {
                persona.setNombres(personaDTO.getNombres());
                persona.setApellidos(personaDTO.getApellidos());
                persona.setCorreos(personaDTO.getCorreos());
                persona.setEdades(personaDTO.getEdades());
                persona.setFecha_nacimientos(personaDTO.getFecha_nacimientos());
                persona.setDirecciones(personaDTO.getDirecciones());
                persona.setContrasenias(personaDTO.getContrasenias());
                this.personaImpl.crearPersona(persona);
            }
            return "Se guardo los datos correctamente";
        }catch (Exception e) {
            return "Fallo algo";
        }
    }

    public String eliminar(int id){
        Persona persona;
        try{
            this.personaImpl.eliminarPersona(id);
            return "Eliminacion exitosa";

        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
