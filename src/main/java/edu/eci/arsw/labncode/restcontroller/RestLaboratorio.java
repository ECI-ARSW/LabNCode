/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.restcontroller;

import edu.eci.arsw.labncode.model.Laboratorio;
import edu.eci.arsw.labncode.model.ManejadorLaboratorio;
import edu.eci.arsw.labncode.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MaríaAlejandra
 */
@RestController
@RequestMapping("/labncode/rest/") 
/*
El historial va mas orientado al profesor.Pensar en recursos y no en servicios

*/

public class RestLaboratorio {
    
    @Autowired
    ManejadorLaboratorio labs;
    
    @RequestMapping(value="/profesor/", method = RequestMethod.GET)
    @ResponseBody
    public List<Persona> consords() {
        return labs.getProfesores();
    }
    
    @RequestMapping(value="/profesor/{idProf}/", method = RequestMethod.GET)
    @ResponseBody
    public Persona consords(int idProf) {
        return labs.getProfesor(idProf);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> persist(@RequestBody Laboratorio lab) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
