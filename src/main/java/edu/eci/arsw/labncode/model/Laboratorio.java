/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 2101240
 */
public class Laboratorio {
    private String nombre;
    private boolean disponibilidad;
    private Date fechaAct;
    private Date fechaDesc;
    private Enunciado enunciado;
    private ArrayList<Sala> salas;
    private Materia materia;
    
    /**
    * 
    * @param sala sala con estudiantes de la materia del laboratorio
    */
    public void agregarSala(Sala sala){
        salas.add(sala);
    }
    /**
     * 
     * @return Profesor  retorna el profesor del laboratorio
     */
    public Persona getProfesor(){
        return materia.getProfesor();
    }

    /**
     * 
     * @return boolean Retorna True si el laboratorio esta disponible para las sala de codigo y False lo contrario
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * 
     * @param sala sala la cual se desea eleiminar del laboratorio
     */
    public void borrarSala(Sala sala) {
        salas.remove(sala);
    }
    
    

    public Laboratorio(String nombre, Materia materia){
        this.nombre = nombre; 
        this.materia = materia; 
        disponibilidad = true; 
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
     * @return the fechaAct
     */
    public Date getFechaAct() {
        return fechaAct;
    }

    /**
     * @param fechaAct the fechaAct to set
     */
    public void setFechaActivacion(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    /**
     * @return the fechaDesc
     */
    public Date getFechaDesactivacion() {
        return fechaDesc;
    }

    /**
     * @param fechaDesc the fechaDesc to set
     */
    public void setFechaDesactivacion(Date fechaDesc) {
        this.fechaDesc = fechaDesc;
    }

    /**
     * @return the enunciado
     */
    public Enunciado getEnunciado() {
        return enunciado;
    }

    /**
     * @return the salas
     */
    public ArrayList<Sala> getSalas() {
        return salas;
    }

    /**
     * @param salas the salas to set
     */
    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
