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
    private ArrayList<Materia>materias;
    private int identificacion;
    public boolean conectado;
    
    public int getIdentificacion() {
        return identificacion;
    }
    
    public abstract void cambiarEstado( Sala sala);
    public abstract boolean estado(Sala sala);
    
    public abstract boolean esProfesor();
    public abstract boolean esEstudiante();

    /**
     * @return the materias
     */
    public ArrayList<Materia> getMaterias() {
        return materias;
    }
    
}
