/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MaríaAlejandra
 */
public class ManejadorLaboratorio {
    private Hashtable<String, Laboratorio> laboratorios;
    private ArrayList<Persona> personas; 
    private ArrayList<Materia> materias;
    
    public ManejadorLaboratorio(){
        laboratorios = new Hashtable<String, Laboratorio>();
    }
    /*
    Retorna un arreglo con todos los profesores. 
    */
    public ArrayList<Persona> getProfesores(){
        ArrayList<Persona> profesores = new ArrayList<Persona>();
        for(Persona p : personas){
            if(p.esProfesor()){
                profesores.add(p);
            }
        }
        return profesores;
    }
    
    public Persona getProfesor(int id){
        return personas.get(id);
    }
    
    public ArrayList<Laboratorio> getHistorial(Profesor p){
        ArrayList<Laboratorio> labs = new ArrayList<Laboratorio>();
        ArrayList<Materia> mat = p.getMaterias();
        for(Materia m : mat){
            for(String s : laboratorios.keySet()){
                if(laboratorios.get(s).getMateria().getSigla().equals(m.getSigla())){
                    labs.add(laboratorios.get(s));
                }
            }
        }
        return labs; 
    }
 
    public ArrayList<Laboratorio> getLaboratorios(){
        ArrayList<Laboratorio> labs = new ArrayList<Laboratorio>();
        Set<String> keys = laboratorios.keySet();
        for(String k : keys){
            labs.add(laboratorios.get(k));
        }
        return labs;
    }

}
