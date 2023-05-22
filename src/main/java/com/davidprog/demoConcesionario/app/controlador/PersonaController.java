package com.davidprog.demoConcesionario.app.controlador;

import com.davidprog.demoConcesionario.app.dto.PersonaDTO;
import com.davidprog.demoConcesionario.app.entity.Persona;
import com.davidprog.demoConcesionario.app.implementacion.PersonaImpl;
import com.davidprog.demoConcesionario.app.negocio.PersonaNegocio;
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
//@RequestMapping(path = "/Persona/", method = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "/persona")
//@CrossOrigin("*")
@CrossOrigin(value = "*",  methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class PersonaController {

    @Autowired
    private PersonaNegocio personaNegocio;

    //@Autowired
    //private PersonaDTO personaDTO;
    @GetMapping("/all")
    @ResponseBody
    //public List<Persona> all(){
    //    return this.personaImpl.encontrarTodos();
    //}

    public ResponseEntity<Map<String, Object>> all(){

        Map<String, Object> res= new HashMap<>();
        List<PersonaDTO> listDTO = this.personaNegocio.encontrarTodos();

        res.put("status persona", HttpStatus.ACCEPTED);
        res.put("data", listDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setId_persona(0);
        personaDTO.setNombres(request.get("nombres").toString());
        personaDTO.setApellidos(request.get("apellidos").toString());
        personaDTO.setCorreos(request.get("correos").toString());
        personaDTO.setEdades(Integer.parseInt(request.get("edades").toString()));
        personaDTO.setFecha_nacimientos(new Date());
        personaDTO.setDirecciones(request.get("direcciones").toString());
        personaDTO.setContrasenias(request.get("contrasenias").toString());

        String respuesta = this.personaNegocio.crearPersona(personaDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Map<String, Object> request) {
        Map<String, Object> res= new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setId_persona(Integer.parseInt(request.get("id_persona").toString()));
        personaDTO.setNombres(request.get("nombres").toString());
        personaDTO.setApellidos(request.get("apellidos").toString());
        personaDTO.setCorreos(request.get("correos").toString());
        personaDTO.setEdades(Integer.parseInt(request.get("edades").toString()));
        personaDTO.setFecha_nacimientos(new Date());
        personaDTO.setDirecciones(request.get("direcciones").toString());
        personaDTO.setContrasenias(request.get("contrasenias").toString());

        String respuesta = this.personaNegocio.crearPersona(personaDTO);
        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarPersona(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        String resp=this.personaNegocio.eliminar(id);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
