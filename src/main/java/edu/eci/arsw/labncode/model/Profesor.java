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
public class Profesor extends Persona {

    public Profesor(String nombre,int identificacion) {
        super(nombre,identificacion);
        
    }

    @Override
    public void cambiarEstado(Grupo sala) {
        sala.cambiarEstado();
        super.conectado=!super.conectado;
    }

    @Override
    public boolean estado(Grupo sala) {
        return sala.isProfesor();
    }

    @Override
    public boolean esProfesor() {
        return true;
    }

    @Override
    public boolean esEstudiante() {
        return false;
    }

}


