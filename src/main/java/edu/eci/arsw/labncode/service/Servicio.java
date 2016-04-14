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

/**
 *
 * @author 2101240
 */
public class Servicio {
    //creacion de la sala
    //creacion de la laboratorio
    //agregar sala al laboratorio
    //agregar estudiantes a la sala
    
    public Laboratorio crearSala(Laboratorio lab, Persona estudiante, String nombre){
        ArrayList<Persona> estudiantes= new ArrayList<Persona>();
        Sala sala=new Sala(nombre,estudiantes);
        sala=agregarPersonaSala(sala, estudiante);
        sala=agregarPersonaSala(sala, lab.getProfesor());
        lab.agregarSala(sala);
        return lab;
    }
    
    public Sala agregarPersonaSala(Sala sala, Persona persona){
        sala.agregarPersona(persona);
        return sala;
    }
    
    public Sala conectarPersona(Persona persona, Sala sala) throws ExceptionLabNCode{
        if(sala.conectarse(persona)){
            return sala;
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.NoExisteEnSala);
        }
    }
    
    public Sala desconectarEstudiante(Sala sala,Persona persona){
        sala.conectarse(persona);
        return sala;
    }
    
    
    public void borrarSala(Sala sala, Laboratorio laboratorio) throws ExceptionLabNCode{
        if(!sala.conectados() && !laboratorio.isDisponibilidad()){
           laboratorio.borrarSala(sala);
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.ConectadoEnSala);
        };
    }
}

