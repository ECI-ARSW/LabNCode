/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author 2101240
 */
public class Enunciado {
    private ArrayList<Punto> puntos;
    
    public Enunciado(){
        puntos = new ArrayList<Punto>();
        
    }
    
    public Punto getPunto(int nombre){
        return getPuntos().get(nombre);
    }
    
    public void addPunto(Punto punto){
        getPuntos().add(punto);
    }

    /**
     * @return the puntos
     */
    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }
    
    
    
}
