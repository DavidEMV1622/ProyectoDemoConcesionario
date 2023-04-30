package com.davidprog.demoConcesionario.app.implementacion;

import com.davidprog.demoConcesionario.app.entity.Rol;
import com.davidprog.demoConcesionario.app.repositorio.RepositorioRol;
import com.davidprog.demoConcesionario.app.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rolimpl implements RolServicio {

    @Autowired
    RepositorioRol repositorioRol;

    @Override
    public List<Rol> encontrarTodos() {

        return this.repositorioRol.findAll();
    }

    @Override
    public Rol encontrarPorId(int id) {

        return this.repositorioRol.encontrarPorId(id);
    }

    @Override
    public void actualizarRol(Rol rol) {
        this.repositorioRol.save(rol);
    }

    @Override
    public void crearRol(Rol rol) {

        this.repositorioRol.save(rol);
    }

    @Override
    public void eliminarRol(int id) {
        Rol rol = this.repositorioRol.encontrarPorId(id);
        if (rol != null) {
            this.repositorioRol.delete(rol);
        }
    }
}
