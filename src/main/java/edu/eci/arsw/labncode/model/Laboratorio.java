/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

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
    private Hashtable<String, Grupo> grupos;
    private Materia materia;

    public Laboratorio(String nombre, Materia materia) {
        this.nombre = nombre;
        this.materia = materia;
        disponibilidad = true;
    }

    /**
     *
     * @param grupo grupo con estudiantes de la materia del laboratorio
     */
    public void agregarSala(Grupo grupo) {
        grupos.put(grupo.getNombre(), grupo);
    }

    /**
     *
     * @return Profesor retorna el profesor del laboratorio
     */
    public Persona getProfesor() {
        //return materia.getProfesor();
        return new Profesor("Micoli");
    }

    /**
     *
     * @return boolean Retorna True si el laboratorio esta disponible para las
     * sala de codigo y False lo contrario
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     *
     * @param grupo grupo la cual se desea eleiminar del laboratorio
     */
    public void borrarSala(Grupo grupo) {
        grupos.remove(grupo.getNombre());
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
    public ArrayList<Grupo> getGrupo() {
        ArrayList<Grupo> grupo = new ArrayList<>();
        Iterator<String> keys = grupos.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            grupo.add(grupos.get(key));
        }
        return grupo;
    }

    /**
     * @param grupo the salas to set
     */
    public void setGrupo(ArrayList<Grupo> grupo) {
        grupos.clear();
        for (int i = 0; i < grupo.size(); i++) {
            grupos.put(grupo.get(i).getNombre(), grupo.get(i));
        }
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

    public Grupo getGrupo(String nombre) {
        return grupos.get(nombre);
    }

}
