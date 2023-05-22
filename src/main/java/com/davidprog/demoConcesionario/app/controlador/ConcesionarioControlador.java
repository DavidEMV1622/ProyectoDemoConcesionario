package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.dto.ConcesionarioDTO;
import com.davidprog.demoConcesionario.app.entity.Concesionario;
import com.davidprog.demoConcesionario.app.implementacion.ConcesionarioImpl;
import com.davidprog.demoConcesionario.app.negocio.ConcesionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/concesionario")
@CrossOrigin(value = "*",  methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class ConcesionarioControlador {

    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res= new HashMap<>();
        List<ConcesionarioDTO> listDTO = this.concesionarioNegocio.encontrarTodos();

        res.put("status concesionario", HttpStatus.ACCEPTED);
        res.put("data", listDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@" + request.toString());
        ConcesionarioDTO concesionarioDTO = new ConcesionarioDTO();

        concesionarioDTO.setId_concesionario(0);
        concesionarioDTO.setNombres(request.get("nombres").toString());
        concesionarioDTO.setDirecciones(request.get("direcciones").toString());
        concesionarioDTO.setCorreos(request.get("correos").toString());
        concesionarioDTO.setTelefonos(Integer.parseInt(request.get("telefonos").toString()));

        String respuesta = this.concesionarioNegocio.crerConcesionario(concesionarioDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@@" + request.toString());
        ConcesionarioDTO concesionarioDTO = new ConcesionarioDTO();

        concesionarioDTO.setId_concesionario(Integer.parseInt(request.get("id_concesionario").toString()));
        concesionarioDTO.setNombres(request.get("nombres").toString());
        concesionarioDTO.setDirecciones(request.get("direcciones").toString());
        concesionarioDTO.setCorreos(request.get("correos").toString());
        concesionarioDTO.setTelefonos(Integer.parseInt(request.get("telefonos").toString()));

        String respuesta = this.concesionarioNegocio.crerConcesionario(concesionarioDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarConcesionario(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        String resp=this.concesionarioNegocio.eliminar(id);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
