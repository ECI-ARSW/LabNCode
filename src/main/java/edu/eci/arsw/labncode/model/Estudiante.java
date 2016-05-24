/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;

/**
 *
 * @author 2101240
 */

public class Estudiante extends Persona{

    public Estudiante() {
    }

    public Estudiante(String nombre,int identificacion) {
        super(nombre,identificacion);
        this.profesor = false;
        
    }
    
    @Override
    public void cambiarEstado(Grupo sala) {
        super.conectado = !super.conectado;
    }

    @Override
    public boolean estado(Grupo sala) {
        return super.conectado;
    }

  

    @Override
    public boolean esProfesor() {
        return false;
    }

    @Override
    public boolean esEstudiante() {
       return true;
    }

  

    

    
    
}
