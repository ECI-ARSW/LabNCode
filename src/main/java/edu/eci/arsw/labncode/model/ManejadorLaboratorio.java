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
    
    public ArrayList<Laboratorio> getLaboratorios(){
        ArrayList<Laboratorio> labs = new ArrayList<Laboratorio>();
        Set<String> keys = laboratorios.keySet();
        for(String k : keys){
            labs.add(laboratorios.get(k));
        }
        return labs;
    }
    
    public ArrayList<Laboratorio> getHistorial(Profesor prof){
         ArrayList<Laboratorio> labs = new ArrayList<Laboratorio>();
         for (Laboratorio l : getLaboratorios()){
             //if(l.getMateria()=)
         }
         return labs; 
    }
}
