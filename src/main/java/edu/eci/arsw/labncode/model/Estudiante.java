/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

/**
 *
 * @author 2101240
 */
public class Estudiante extends Persona{

    @Override
    public void cambiarEstado(Sala sala) {
        super.conectado = !super.conectado;
    }

    @Override
    public boolean estado(Sala sala) {
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
