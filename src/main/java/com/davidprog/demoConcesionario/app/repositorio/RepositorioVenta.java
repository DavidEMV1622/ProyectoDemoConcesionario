package com.davidprog.demoConcesionario.app.repositorio;

import com.davidprog.demoConcesionario.app.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVenta extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT v FROM Venta v WHERE v.id_venta=id")
    public Venta encontrarPorId(int id);
}
