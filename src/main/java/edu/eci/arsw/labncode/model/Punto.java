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
public class Punto {
    private String nombre;
    private String descripcion;
    private double peso;

    public Punto() {
    }
    n
            
    public Punto(String nombre, String descripcion){
        this.nombre=nombre; 
        this.descripcion = descripcion;
        
    }

    public Punto(String nombre, String descripcion, double peso) {
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.peso=peso;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    boolean verifica() {
        return true;
    }
    
    
}
