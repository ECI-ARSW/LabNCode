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
public class Materia {

    private String nombre;
    private String sigla;
    private String descripcion;
    private ArrayList<Persona> personas;

    public Persona getProfesor() {
        Persona profesor = null;
        for (Persona i : personas) {
            if (i instanceof Profesor) {
                profesor = i;
            }
        }
        return profesor;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
