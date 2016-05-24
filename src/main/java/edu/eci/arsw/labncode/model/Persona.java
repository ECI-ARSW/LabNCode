/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.util.ArrayList;

/**
 *
 * @author 2101240
 */



public abstract class Persona {
    private String nombre;
    private int identificacion;
    public boolean conectado;
    public boolean profesor;

    public Persona() {
    }
    
    
    public Persona(String nombre, int identificacion){
        this.nombre = nombre; 
        this.identificacion=identificacion;
        conectado = false;
    }

    public boolean isConectado() {
        return conectado;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }
    
    public abstract void cambiarEstado( Grupo sala);
    public abstract boolean estado(Grupo sala);
    
    public abstract boolean esProfesor();
    public abstract boolean esEstudiante();

    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the profesor
     */
    public boolean isProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(boolean profesor){
        this.profesor = profesor;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    
}
