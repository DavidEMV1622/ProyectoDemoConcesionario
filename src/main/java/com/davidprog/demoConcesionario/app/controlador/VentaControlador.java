package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.dto.VentaDTO;
import com.davidprog.demoConcesionario.app.entity.Venta;
import com.davidprog.demoConcesionario.app.implementacion.VentaImpl;
import com.davidprog.demoConcesionario.app.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/venta")
@CrossOrigin(value = "*",  methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class VentaControlador {

    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {

        Map<String, Object> res= new HashMap<>();
        List<VentaDTO> listDTO = this.ventaNegocio.encontrarTodos();

        res.put("status venta", HttpStatus.ACCEPTED);
        res.put("data", listDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId_venta(0);
        ventaDTO.setFecha_ventas(new Date());
        ventaDTO.setMonto_ventas(Integer.parseInt(request.get("monto_ventas").toString()));

        String respuesta = this.ventaNegocio.crearVenta(ventaDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
