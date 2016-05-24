/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

/**
 *
 * @author 2101240
 */
public class Materia {

    @JsonIgnore
    private String nombre;
    @JsonIgnore
    private String descripcion;
    @JsonIgnore
    private ArrayList<Persona> personas;
    
    private String sigla; 
    @JsonIgnore
    private Profesor profesor;

    public Materia() {
    }
    
    public Materia(String nombre, String sigla, String descripcion){
        this.nombre= nombre; 
        this.sigla = sigla;
        this.descripcion= descripcion;
        personas = new ArrayList<Persona>();
    }
    
    public void registrarPersona(Persona p){
        if(p.isProfesor()){
            profesor=(Profesor)p;
        }
        personas.add(p);
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
    
    public boolean estaInscrito(Persona p){
       boolean r = true;
       for(int i =0; i<personas.size() && r; i++){
           r=personas.get(i).getIdentificacion()!=p.getIdentificacion();
           System.out.println(personas.get(i).getIdentificacion()+ " "+ p.getIdentificacion());
       }
       return !r;
    }

}
