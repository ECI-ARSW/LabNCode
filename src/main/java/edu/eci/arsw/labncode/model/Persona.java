/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

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
    public boolean estudiante;
    
    public Persona(String nombre, int identificacion){
        this.nombre = nombre; 
        this.identificacion=identificacion;
        conectado = false;
    }

    public boolean isConectado() {
        return conectado;
    }

    public boolean isProfesor() {
        return profesor;
    }

    public boolean isEstudiante() {
        return estudiante;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }
    
    public abstract void cambiarEstado( Grupo sala);
    public abstract boolean estado(Grupo sala);
    
    public abstract boolean esProfesor();
    public abstract boolean esEstudiante();

    
    public void setId(int id){
        this.identificacion= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
