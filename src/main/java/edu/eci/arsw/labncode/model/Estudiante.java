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
public class Estudiante extends Persona{

    public Estudiante(String nombre, ArrayList<Materia> materias) {
        super(nombre, materias);
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

    @Override
    public boolean estoyEnMateria(Materia materia) {
        boolean si=true;
        ArrayList<Materia> mat=super.materias;
        for(int i =0 ; i< mat.size() && si; i++){
            si=mat.get(i).getSigla().equals(materia.getSigla());
        }
        return !si;
    }
    
}
