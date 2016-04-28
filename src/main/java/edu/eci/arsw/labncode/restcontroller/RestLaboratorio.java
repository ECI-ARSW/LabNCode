/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.restcontroller;

import edu.eci.arsw.labncode.model.Archivo;
import edu.eci.arsw.labncode.model.Enunciado;
import edu.eci.arsw.labncode.model.Grupo;
import edu.eci.arsw.labncode.model.Laboratorio;
import edu.eci.arsw.labncode.model.ManejadorLaboratorio;
import edu.eci.arsw.labncode.model.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static org.junit.runner.Request.method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/servicios") 
/*
El historial va mas orientado al profesor.Pensar en recursos y no en servicios

*/

public class RestLaboratorio {
    
    @Autowired
    ManejadorLaboratorio labs;
    
    
    @RequestMapping(value="/profesor", method = RequestMethod.GET)
    @ResponseBody
    public List<Persona> getProfesores() {
        return labs.getProfesores();
    }
    
        
    @RequestMapping(value="/laboratorio", method = RequestMethod.GET)
    @ResponseBody
    public List<Laboratorio> getLaboratorios() {
        return labs.getLaboratorios();
    }
    
    
    @RequestMapping(value="/profesor/{idProf}", method = RequestMethod.GET)
    public Persona getProfesor(@PathVariable Integer idProf) throws ExceptionLabNCode {
        return labs.getProfesor(idProf);
    }
    
    @RequestMapping(value="/estudiante", method = RequestMethod.GET)
    @ResponseBody
    public List<Persona> getEstudiante() {
        System.out.println("aqui entra");
        return labs.getEstudiantes();
    }
    
    @RequestMapping(value="/estudiante/{idEst}", method = RequestMethod.GET)
    public Persona getEstudiante(@PathVariable Integer idEst) throws ExceptionLabNCode {
        return labs.getEstudiante(idEst);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addLaboratorio(@RequestBody Laboratorio lab) {
        labs.addLaboratorio(lab);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
    @RequestMapping(value="laboratorio/{idLab}", method = RequestMethod.GET)
    @ResponseBody
    public Laboratorio getLab(String idLab){
        return labs.getLaboratorio(idLab);
    }
    
    @RequestMapping(value="laboratorio/{idLab}/{idEstudiante}/{grupo}" , method=RequestMethod.POST)
    public ResponseEntity<?> addGrupo(String idLab , String idEstudiante, String grupo) {
        try {
            labs.newSala(labs.getLaboratorio(idLab), labs.getEstudiante(Integer.parseInt(idEstudiante)), grupo);
                    } catch (ExceptionLabNCode ex) {
            Logger.getLogger(RestLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="laboratorio/{idLab}/{idGrupo}", method = RequestMethod.GET)
    @ResponseBody
    public Grupo getGrupo(String idLab, String idGrupo){
        return labs.getGrupo(idLab, idGrupo);
    }
    
    @RequestMapping(value="/laboratorio/{idLab}/enunciado", method = RequestMethod.GET)
    @ResponseBody
    public Enunciado getEnunciado(String idLab){
        return labs.getLaboratorio(idLab).getEnunciado();
    }
    
    @RequestMapping(value="/laboratorio/{idLab}/{idGrupo}/{idArchivo}", method = RequestMethod.GET)
    @ResponseBody
    public Archivo getArchivo(String idLab,String idGrupo, int Archivo){
        return labs.getLaboratorio(idLab).getGrupo(idGrupo).getArchivo(Archivo);
    }
}
