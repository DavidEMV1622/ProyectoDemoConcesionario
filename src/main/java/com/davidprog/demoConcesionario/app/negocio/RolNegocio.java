package com.davidprog.demoConcesionario.app.negocio;

import com.davidprog.demoConcesionario.app.dto.RolDTO;
import com.davidprog.demoConcesionario.app.entity.Persona;
import com.davidprog.demoConcesionario.app.entity.Rol;
import com.davidprog.demoConcesionario.app.implementacion.Rolimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolNegocio {

    @Autowired
    private Rolimpl rolimpl;

    private List<RolDTO> listDTORol;

    public List<RolDTO> encontrarTodos() {
        listDTORol = new ArrayList<>();
        this.rolimpl.encontrarTodos().forEach(rol -> {
            RolDTO rolDTO = new RolDTO();
            rolDTO.setId_rol(rol.getId_rol());
            rolDTO.setNombres(rol.getNombres());
            this.listDTORol.add(rolDTO);
        });
        return this.listDTORol;
    }

    public String crerRol(RolDTO rolDTO) {
        Rol rol = new Rol();
        try {
            if (rolDTO.getId_rol() != 0) {
                rol.setId_rol(rolDTO.getId_rol());
                rol.setNombres(rolDTO.getNombres());
                this.rolimpl.actualizarRol(rol);

            } else {
                rol.setNombres(rolDTO.getNombres());
                this.rolimpl.crearRol(rol);
            }
            return "Se guardo los datos correctamente";
        }catch (Exception e) {
            return "Fallo algo";
        }
    }

    public String eliminar(int id){
        Persona persona;
        try{
            this.rolimpl.eliminarRol(id);
            return "Eliminacion exitosa";

        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
