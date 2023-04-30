package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.dto.AutomovilDTO;
import com.davidprog.demoConcesionario.app.entity.Automovil;
import com.davidprog.demoConcesionario.app.implementacion.Automovilimpl;
import com.davidprog.demoConcesionario.app.negocio.AutomovilNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/automovil")
@CrossOrigin(value = "*",  methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class AutomovilControlador {

    @Autowired
    private AutomovilNegocio automovilNegocio;

    @GetMapping("all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res= new HashMap<>();
        List<AutomovilDTO> listDTO = this.automovilNegocio.encontrarTodos();

        res.put("status automovil", HttpStatus.ACCEPTED);
        res.put("data", listDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@@@@@" + request.toString());
        AutomovilDTO automovilDTO = new AutomovilDTO();

        automovilDTO.setId_automovil(0);
        automovilDTO.setMatriculas(request.get("matriculas").toString());
        automovilDTO.setMarcas(request.get("marcas").toString());
        automovilDTO.setModelos(request.get("modelos").toString());
        automovilDTO.setAnios(Integer.parseInt(request.get("anios").toString()));
        automovilDTO.setColores(request.get("colores").toString());
        automovilDTO.setKilometrajes(Integer.parseInt(request.get("kilometrajes").toString()));
        automovilDTO.setCan_puertas(Integer.parseInt(request.get("can_puertas").toString()));
        automovilDTO.setTipos_combustibles(request.get("tipos_combustibles").toString());
        automovilDTO.setCap_personas(Integer.parseInt(request.get("cap_personas").toString()));
        automovilDTO.setPrecios(Integer.parseInt(request.get("precios").toString()));

        String respuesta = this.automovilNegocio.crearAutomovil(automovilDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@@@@@" + request.toString());
        AutomovilDTO automovilDTO = new AutomovilDTO();

        automovilDTO.setId_automovil(Integer.parseInt(request.get("id_automovil").toString()));
        automovilDTO.setMatriculas(request.get("matriculas").toString());
        automovilDTO.setMarcas(request.get("marcas").toString());
        automovilDTO.setModelos(request.get("modelos").toString());
        automovilDTO.setAnios(Integer.parseInt(request.get("anios").toString()));
        automovilDTO.setColores(request.get("colores").toString());
        automovilDTO.setKilometrajes(Integer.parseInt(request.get("kilometrajes").toString()));
        automovilDTO.setCan_puertas(Integer.parseInt(request.get("can_puertas").toString()));
        automovilDTO.setTipos_combustibles(request.get("tipos_combustibles").toString());
        automovilDTO.setCap_personas(Integer.parseInt(request.get("cap_personas").toString()));
        automovilDTO.setPrecios(Integer.parseInt(request.get("precios").toString()));

        String respuesta = this.automovilNegocio.crearAutomovil(automovilDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
