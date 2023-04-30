package com.davidprog.demoConcesionario.app.servicio;

import com.davidprog.demoConcesionario.app.entity.Persona;

import java.util.List;

public interface PersonaServicio {

    public List<Persona> encontrarTodos();
    public Persona encontrarPorId(int id);

    public void actualizarPersona(Persona persona);

    public void crearPersona(Persona persona);

    public void eliminarPersona(int id);

}
