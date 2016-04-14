/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.service;


import edu.eci.arsw.labncode.model.Estudiante;
import edu.eci.arsw.labncode.model.Laboratorio;
import edu.eci.arsw.labncode.model.Persona;
import edu.eci.arsw.labncode.model.Sala;
import java.util.ArrayList;

import edu.eci.arsw.labncode.model.Laboratorio;
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
 * @author 2101240
 */
public class Servicio {
    @Autowired 
    Laboratorio lab; 
    
    /**
    * 
    * @param lab Laboratorio en la cual se va a crear la sala
    * @param estudiante El estudiante quien crea la sala
    * @param nombre El nombre de la sala
    * @return Retorna el laboratorio con la sala agregada.
    */    
    public Laboratorio crearSala(Laboratorio lab, Persona estudiante, String nombre){
        ArrayList<Persona> estudiantes= new ArrayList<Persona>();
        Sala sala=new Sala(nombre,estudiantes);
        sala=agregarPersonaSala(sala, estudiante);
        sala=agregarPersonaSala(sala, lab.getProfesor());
        lab.agregarSala(sala);
        return lab;
    }
    
    /**
     * 
     * @param sala Sala en la cual se desea autorizar el ingreso a la persona
     * @param persona La persona a la cual le vamos a dar la autorizacion
     * @return retorna la sala con la autorizacion 
     */
    public Sala agregarPersonaSala(Sala sala, Persona persona){
        sala.agregarPersona(persona);
        return sala;
    }
    
    /**
     * 
     * @param persona Persona que desea entrar a la sala
     * @param sala La sala a la cual la persona quiera entrar
     * @return retorna la sala con la persona conectada
     * @throws ExceptionLabNCode Lanza excepcion cuando la persona no esta autorizada para ingresar a la sala
     */
    public Sala conectarPersona(Persona persona, Sala sala) throws ExceptionLabNCode{
        if(sala.conectarse(persona)){
            return sala;
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.NoExisteEnSala);
        }
    }
    /**
     * 
     * @param sala la sala en la cual el estudiante se va a desconectar
     * @param persona la persona que se quiere desconectar
     * @return retorna la sala sin la persona
     */
    public Sala desconectarEstudiante(Sala sala,Persona persona){
        sala.conectarse(persona);
        return sala;
    }
    
    /**
     * 
     * @param sala La sala que se quiere borrar
     * @param laboratorio Lanoratorio donde se va a borrar la sala
     * @throws ExceptionLabNCode Si el profesor o los estudiantes sigue conectados en la sala
     */
    public void borrarSala(Sala sala, Laboratorio laboratorio) throws ExceptionLabNCode{
        if(!sala.conectados() && !laboratorio.isDisponibilidad()){
           laboratorio.borrarSala(sala);
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.ConectadoEnSala);
        };
    }
}

