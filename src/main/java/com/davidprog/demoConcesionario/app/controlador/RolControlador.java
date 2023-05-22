package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.dto.RolDTO;
import com.davidprog.demoConcesionario.app.entity.Rol;
import com.davidprog.demoConcesionario.app.implementacion.Rolimpl;
import com.davidprog.demoConcesionario.app.negocio.RolNegocio;
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
    private RolNegocio rolNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res= new HashMap<>();
        List<RolDTO> listRolDTO = this.rolNegocio.encontrarTodos();

        res.put("status rol", HttpStatus.ACCEPTED);
        res.put("data", listRolDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        RolDTO rolDTO = new RolDTO();

        rolDTO.setId_rol(0);
        rolDTO.setNombres(request.get("nombres").toString());

        String respuesta = this.rolNegocio.crerRol(rolDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        RolDTO rolDTO = new RolDTO();

        rolDTO.setId_rol(Integer.parseInt(request.get("id_rol").toString()));
        rolDTO.setNombres(request.get("nombres").toString());

        String respuesta = this.rolNegocio.crerRol(rolDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarRol(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        String resp=this.rolNegocio.eliminar(id);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
