package com.davidprog.demoConcesionario.app.repositorio;

import com.davidprog.demoConcesionario.app.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {

    @Query(value = "SELECT r FROM Rol r WHERE r.id_rol=id")
    public Rol encontrarPorId(int id);
}
