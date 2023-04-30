package com.davidprog.demoConcesionario.app.implementacion;

import com.davidprog.demoConcesionario.app.entity.Concesionario;
import com.davidprog.demoConcesionario.app.repositorio.RepositorioConcesionario;
import com.davidprog.demoConcesionario.app.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioServicio {

    @Autowired
    RepositorioConcesionario repositorioConcesionario;

    @Override
    public List<Concesionario> encontrarTodos() {

        return this.repositorioConcesionario.findAll();
    }

    @Override
    public Concesionario encontrarPorId(int id) {

        Concesionario concesionario = this.repositorioConcesionario.encontrarPorId(id);
        return concesionario;
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
        if (concesionario.getId_concesionario()!=0){
            this.repositorioConcesionario.save(concesionario);
        }
    }

    @Override
    public void crearConcesionario(Concesionario concesionario) {

        this.repositorioConcesionario.save(concesionario);
    }

    @Override
    public void eliminarConcesionario(int id) {
        Concesionario concesionario = this.repositorioConcesionario.encontrarPorId(id);

        if(concesionario!=null) {
            this.repositorioConcesionario.delete(concesionario);
        }
    }
}
