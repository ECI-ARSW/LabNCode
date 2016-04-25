/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import edu.eci.arsw.labncode.restcontroller.ExceptionLabNCode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mar�aAlejandra
 */
public class ManejadorLaboratorio {
    private Hashtable<String, Laboratorio> laboratorios;
    private ArrayList<Persona> personas; 
    private Hashtable<String, Materia> materias;
    
    public ManejadorLaboratorio(){
        laboratorios = new Hashtable<String, Laboratorio>();
        materias= new Hashtable<String, Materia>();
        personas= new ArrayList<Persona>();
        cargaDatos(this);
    }
    /*
    Retorna un arreglo con todos los profesores. 
    */
    public ArrayList<Persona> getProfesores(){
        ArrayList<Persona> profesores = new ArrayList<>();
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
    
    public void addProfesor(Profesor p){
        p.setId(personas.size());
        personas.add(p);
    }
    
    public Persona getEstudiante (int id){
        return personas.get(id);
    }
    
    public ArrayList<Persona> getEstudiantes(){
        ArrayList<Persona> estudiantes = new ArrayList<>();
        for(Persona p : personas){
            if(p.esEstudiante()){
                estudiantes.add(p);
            }
        }
        return estudiantes;
    }
    
    public void addEstudiante(Estudiante e){
        e.setId(personas.size());
        personas.add(e);
    }
    
    public void addMateria(Materia m){
        materias.put(m.getSigla(), m);
    }
    
    private ArrayList<Materia> getMateriasPersona(Persona p){
        ArrayList<Materia> mat = new ArrayList<Materia>();
        for(String s: materias.keySet()){
            if(materias.get(s).estaInscrito(p)){
                mat.add(materias.get(s));
            }
        }
        return mat;
    }
    
    public ArrayList<Laboratorio> getHistorial(Profesor p){
        ArrayList<Laboratorio> labs = new ArrayList<>();
        ArrayList<Materia> mat = getMateriasPersona(p);
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
        ArrayList<Laboratorio> labs = new ArrayList<>();
        Set<String> keys = laboratorios.keySet();
        for(String k : keys){
            labs.add(laboratorios.get(k));
        }
        return labs;
    }
    

    /**
    * 
    * @param lab Laboratorio en la cual se va a crear la grupo
    * @param estudiante El estudiante quien crea la grupo
    * @param nombre El nombre de la grupo
    * @return Retorna el laboratorio con la grupo agregada.
     * @throws edu.eci.arsw.labncode.restcontroller.ExceptionLabNCode
    */    
    public Laboratorio crearSala(Laboratorio lab, Persona estudiante, String nombre) throws ExceptionLabNCode{
        ArrayList<Persona> estudiantes= new ArrayList<>();
        if(lab.getMateria().estaInscrito(estudiante)){
            Grupo grupo=new Grupo(nombre,estudiantes,lab);
            grupo=agregarPersonaSala(grupo, estudiante);
            grupo=agregarPersonaSala(grupo, lab.getProfesor());
            lab.agregarSala(grupo);
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteOtraMateria);
        }
        return lab;
    }
    
    /**
     * 
     * @param grupo Grupo en la cual se desea autorizar el ingreso a la persona
     * @param persona La persona a la cual le vamos a dar la autorizacion
     * @return retorna la grupo con la autorizacion 
     * @throws edu.eci.arsw.labncode.restcontroller.ExceptionLabNCode 
     */
    public Grupo agregarPersonaSala(Grupo grupo, Persona persona) throws ExceptionLabNCode{
        if(grupo.getLaboratorio().getMateria().estaInscrito(persona)){
            grupo.agregarPersona(persona);
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteOtraMateria);
        }
        return grupo;
    }
    
    /**
     * 
     * @param persona Persona que desea entrar a la grupo
     * @param grupo La grupo a la cual la persona quiera entrar
     * @return retorna la grupo con la persona conectada
     * @throws ExceptionLabNCode Lanza excepcion cuando la persona no esta autorizada para ingresar a la grupo
     */
    public Grupo conectarPersona(Persona persona, Grupo grupo) throws ExceptionLabNCode{
        if(grupo.conectarse(persona)){
            return grupo;
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.NoExisteEnSala);
        }
    }
    /**
     * 
     * @param grupo la grupo en la cual el estudiante se va a desconectar
     * @param persona la persona que se quiere desconectar
     * @return retorna la grupo sin la persona
     */
    public Grupo desconectarEstudiante(Grupo grupo,Persona persona){
        grupo.conectarse(persona);
        return grupo;
    }
    
    /**
     * 
     * @param grupo La grupo que se quiere borrar
     * @param laboratorio Lanoratorio donde se va a borrar la grupo
     * @throws ExceptionLabNCode Si el profesor o los estudiantes sigue conectados en la grupo
     */
    public void borrarSala(Grupo grupo, Laboratorio laboratorio) throws ExceptionLabNCode{
        if(!grupo.conectados() && !laboratorio.isDisponibilidad()){
           laboratorio.borrarSala(grupo);
        }else{
            throw new ExceptionLabNCode(ExceptionLabNCode.ConectadoEnSala);
        }
    }
    
    public Laboratorio getLaboratorio(String nombreLab){
        return laboratorios.get(nombreLab);
    }
    
    public Grupo getGrupo(String laboratorio, String Grupo){
        return laboratorios.get(laboratorio).getGrupo(Grupo);
    }
    
    public void addLaboratorio(Laboratorio lab){
        laboratorios.put(lab.getNombre(), lab);
    }

    private void cargaDatos(ManejadorLaboratorio lab){
        lab.addMateria(new Materia("Arquitecturas de Software", "ARSW", "Desarrollo"));
        lab.addProfesor(new Profesor("Mario Java"));
        lab.addEstudiante(new Estudiante("Alejandra"));
        lab.addEstudiante(new Estudiante("Andres"));
    }


}
