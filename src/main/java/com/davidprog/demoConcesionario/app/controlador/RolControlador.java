package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.entity.Rol;
import com.davidprog.demoConcesionario.app.implementacion.Rolimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/rol")
@CrossOrigin(value = "*",  methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class RolControlador {

    @Autowired
    Rolimpl rolImpl;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        List<Rol> listRol = this.rolImpl.encontrarTodos();
        System.out.println(listRol.toString());

        Map<String, Object> res= new HashMap<>();

        res.put("status rol", HttpStatus.ACCEPTED);
        res.put("data", listRol);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
