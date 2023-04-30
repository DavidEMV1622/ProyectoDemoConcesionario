package com.davidprog.demoConcesionario.app.implementacion;

import com.davidprog.demoConcesionario.app.entity.Persona;
import com.davidprog.demoConcesionario.app.repositorio.RepositorioPersona;
import com.davidprog.demoConcesionario.app.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImpl implements PersonaServicio {
    @Autowired
    RepositorioPersona repositorioPersona;

    @Override
    public List<Persona> encontrarTodos() {

        return this.repositorioPersona.findAll();
    }

    @Override
    public Persona encontrarPorId(int id) {

        Persona persona = this.repositorioPersona.encontrarPorId(id);
        return persona;
    }

    @Override
    public void actualizarPersona(Persona persona) {
        if (persona.getId_persona()!=0){
            this.repositorioPersona.save(persona);
        }
    }

    @Override
    public void crearPersona(Persona persona) {

        this.repositorioPersona.save(persona);
;   }

    @Override
    public void eliminarPersona(int id) {

        Persona persona = this.repositorioPersona.encontrarPorId(id);

        if (persona!=null) {
            this.repositorioPersona.delete(persona);
        }
    }
}
