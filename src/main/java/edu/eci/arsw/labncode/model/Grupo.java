/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



/**
 *
 * @author 2101240
 */
public class Grupo {

    private String nombre;
    private ArrayList<Persona> personas;
    private boolean profesor;
    private Laboratorio laboratorio;
    private Map<Integer, ArchivoClient> archivos;
    private double porcentaje;

    public Grupo(String nombre, ArrayList<Persona> personas,Laboratorio laboratorio) {
        this.nombre = nombre;
        this.personas = personas;
        profesor = false;
        this.laboratorio=laboratorio;
        archivos=new TreeMap<>();
        porcentaje=0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean desconectarPersona(Persona persona) {
        boolean noExiste = true;
        for (int i = 0; i < personas.size() && noExiste; i++) {
            if (personas.get(i).getIdentificacion() == persona.getIdentificacion()) {
                noExiste = false;
                persona.cambiarEstado(this);
            }
        }
        return !noExiste;
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

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public ArrayList getArchivo() {
        ArrayList<ArchivoClient> archivo= new ArrayList<>();
        Iterator<Integer> keys=this.archivos.keySet().iterator();
        while(keys.hasNext()){
            int key=keys.next();
            archivo.add(archivos.get(key));
        }
        return archivo;
    }

    public void setArchivo(ArrayList<ArchivoClient> archivo) {
        archivos.clear();
        for(int i =0; i<archivo.size();i++){
            archivos.put(archivo.get(i).getId(),archivo.get(i));
        }
    }
    
    public ArchivoClient getArchivo(int idArchivo){
        return archivos.get(idArchivo);
    }

    public Laboratorio laboratorio() {
       return laboratorio;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    void asignarPorcentaje(double peso) {
        porcentaje+=peso;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
    
    
    
}
