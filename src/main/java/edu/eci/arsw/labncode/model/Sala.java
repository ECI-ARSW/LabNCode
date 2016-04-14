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
public class Sala {

    private String nombre;
    private ArrayList<Persona> personas;
    private boolean profesor;

    public Sala(String nombre, ArrayList<Persona> personas) {
        this.nombre = nombre;
        this.personas = personas;
        profesor = false;
    }

    public boolean isProfesor() {
        return profesor;
    }

    public void setProfesor(boolean profesor) {
        this.profesor = profesor;
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public boolean conectarse(Persona persona) {
        boolean noExiste = true;
        for (int i = 0; i < personas.size() && noExiste; i++) {
            if (personas.get(i).getIdentificacion() == persona.getIdentificacion()) {
                noExiste = false;
                persona.cambiarEstado(this);
            }
        }
        return !noExiste;
    }

    public void desconectarPersona(Persona persona) {
        if (persona instanceof Estudiante && personas.contains(persona)) {
            persona.cambiarEstado(this);
        }
    }

    void cambiarEstado() {
        profesor = !profesor;
    }

    public boolean conectados() {
        boolean conectado = true;
        for (int i = 0; i < personas.size() && conectado; i++) {
            conectado = !personas.get(i).estado(this);
        }
        return !conectado;
    }

}
