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
    private String nombre;
    private Hashtable<String,Punto> puntos;
    
    public Punto getPunto(String nombre){
        return puntos.get(nombre);
    }
    
}
