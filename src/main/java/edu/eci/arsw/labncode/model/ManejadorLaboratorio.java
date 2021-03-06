/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.model;

import edu.eci.arsw.labncode.restcontroller.ExceptionLabNCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mar�aAlejandra
 */
public class ManejadorLaboratorio {

    private Hashtable<String, Laboratorio> laboratorios;
    private ArrayList<Persona> personas;    
    private Hashtable<String, Materia> materias;
    
    public ManejadorLaboratorio() {
        laboratorios = new Hashtable<String, Laboratorio>();
        materias = new Hashtable<String, Materia>();
        personas = new ArrayList<Persona>();
        cargaDatos(this);
    }

    /*
    Retorna un arreglo con todos los profesores. 
     */
    public ArrayList<Persona> getProfesores() {
        ArrayList<Persona> profesores = new ArrayList<>();
        for (Persona p : personas) {
            if (p.esProfesor()) {
                profesores.add(p);
            }
        }
        return profesores;
    }
    
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /*
    Retorna un profesor en específico
     */
    public Persona getProfesor(int id) throws ExceptionLabNCode {
        if (id >= personas.size()) {
            throw new ExceptionLabNCode(ExceptionLabNCode.ProfesorInexistente);
        }
        if (personas.get(id) == null) {
            throw new ExceptionLabNCode(ExceptionLabNCode.ProfesorInexistente);
        }
        if (!personas.get(id).esProfesor()) {
            throw new ExceptionLabNCode(ExceptionLabNCode.NoEsProfesor);
        }
        return personas.get(id);
    }
    
    public void addProfesor(Profesor p) {
        p.setIdentificacion(personas.size());
        personas.add(p);
    }
    
    public Persona getEstudiante(int id) throws ExceptionLabNCode {
        if (id >= personas.size()) {
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteInexistente);
        }
        if (personas.get(id) == null) {
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteInexistente);
        }
        if (!personas.get(id).esEstudiante()) {
            throw new ExceptionLabNCode(ExceptionLabNCode.NoEsEstudiante);
        }
        return personas.get(id);
    }
    
    public Persona getPersona(int id) throws ExceptionLabNCode {
        if (id >= personas.size()) {
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteInexistente);
        }
        if (personas.get(id) == null) {
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteInexistente);
        }
        return personas.get(id);
    }
    
    public ArrayList<Persona> getEstudiantes() {
        ArrayList<Persona> estudiantes = new ArrayList<>();
        for (Persona p : personas) {
            if (p.esEstudiante()) {
                estudiantes.add(p);
            }
        }
        return estudiantes;
    }
    
    public void addEstudiante(Estudiante e) {
        e.setIdentificacion(personas.size());
        personas.add(e);
    }
    
    public void addMateria(Materia m) {
        materias.put(m.getSigla(), m);
    }
    
    private ArrayList<Materia> getMateriasPersona(Persona p) {
        ArrayList<Materia> mat = new ArrayList<Materia>();
        for (String s : materias.keySet()) {
            if (materias.get(s).estaInscrito(p)) {
                mat.add(materias.get(s));
            }
        }
        return mat;
    }
    
    public Materia getMateria(String materia) {
        return materias.get(materia);
    }
    
    public List<Laboratorio> getHistorial(Profesor p) {
        ArrayList<Laboratorio> labs = new ArrayList<>();
        ArrayList<Materia> mat = getMateriasPersona(p);
        for (Materia m : mat) {
            for (String s : laboratorios.keySet()) {
                if (laboratorios.get(s).getMateria().getSigla().equals(m.getSigla())) {
                    labs.add(laboratorios.get(s));
                }
            }
        }
        return labs;        
    }
    
    public ArrayList<Laboratorio> getLaboratorios() {
        ArrayList<Laboratorio> labs = new ArrayList<>();
        Set<String> keys = laboratorios.keySet();
        for (String k : keys) {
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
    public Laboratorio newSala(Laboratorio lab, Persona estudiante, String nombre) throws ExceptionLabNCode {
        ArrayList<Persona> estudiantes = new ArrayList<>();
        if (lab.getMateria().estaInscrito(estudiante)) {
            Grupo grupo = new Grupo(nombre, estudiantes, lab);
            grupo = addPersonaGrupoAutorizacion(grupo, estudiante);
            grupo = addPersonaGrupoAutorizacion(grupo, lab.getProfesor());
            lab.addGrupo(grupo);
        } else {
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
    public Grupo addPersonaGrupoAutorizacion(Grupo grupo, Persona persona) throws ExceptionLabNCode {
        if (grupo.laboratorio().getMateria().estaInscrito(persona)) {
            grupo.agregarPersona(persona);
        } else {
            throw new ExceptionLabNCode(ExceptionLabNCode.EstudianteOtraMateria);
        }
        return grupo;
    }

    /**
     *
     * @param persona Persona que desea entrar a la grupo
     * @param grupo La grupo a la cual la persona quiera entrar
     * @return retorna grupo con la persona conectada
     * @throws ExceptionLabNCode Lanza excepcion cuando la persona no esta
     * autorizada para ingresar a la grupo
     */
    public Grupo addPersonaGrupo(Persona persona, Grupo grupo) throws ExceptionLabNCode {
        if (grupo.conectarse(persona)) {
            return grupo;
        } else {
            throw new ExceptionLabNCode(ExceptionLabNCode.NoExisteEnSala);
        }
    }

    /**
     *
     * @param grupo la grupo en la cual el estudiante se va a desconectar
     * @param persona la persona que se quiere desconectar
     * @return retorna la grupo sin la persona
     */
    public Grupo removeEstudiante(Grupo grupo, Persona persona) {
        grupo.conectarse(persona);
        return grupo;
    }

    /**
     *
     * @param grupo La grupo que se quiere borrar
     * @param laboratorio Lanoratorio donde se va a borrar la grupo
     * @throws ExceptionLabNCode Si el profesor o los estudiantes sigue
     * conectados en la grupo
     */
    public void deleteGrupo(Grupo grupo, Laboratorio laboratorio) throws ExceptionLabNCode {
        if (!grupo.conectados() && !laboratorio.isDisponibilidad()) {
            laboratorio.borrarSala(grupo);
        } else {
            throw new ExceptionLabNCode(ExceptionLabNCode.ConectadoEnSala);
        }
    }
    
    public Laboratorio getLaboratorio(String nombreLab) {
        return laboratorios.get(nombreLab);
    }
    
    public Grupo getGrupo(String laboratorio, String Grupo) {
        return laboratorios.get(laboratorio).getGrupo(Grupo);
    }
    
    public void addLaboratorio(Laboratorio lab) {
        laboratorios.put(lab.getNombre(), lab);
    }

    /*
        Añade el enunciado del laborario. 
        @param lab Laboratorio al que se le va a añadir el enunciado
        @param e Enunciado que se agregara al laboratorio
    
     */
    public void setEnunciado(String lab, Enunciado e) {
        this.getLaboratorio(lab).setEnunciado(e);
    }
    
    private void cargaDatos(ManejadorLaboratorio lab) {
        try {
            lab.addMateria(new Materia("Arquitecturas de Software", "ARSW", "Desarrollo"));
            lab.addProfesor(new Profesor("Mario Java", 123456));
            materias.get("ARSW").registrarPersona(personas.get(0));
            Estudiante alejandra = new Estudiante("Alejandra", 21000012);
            Estudiante andres = new Estudiante("Andres", 2101240);
            lab.addEstudiante(alejandra);
            lab.addEstudiante(andres);
            materias.get("ARSW").registrarPersona(personas.get(1));
            materias.get("ARSW").registrarPersona(personas.get(2));
            Laboratorio l = new Laboratorio("ARSW-Lab", materias.get("ARSW"));
            l.setFechaAct(new Date());
            Enunciado e = new Enunciado();
            Punto a = new Punto("Punto1", "Punto de servicios REST", 20.0);
            Punto b = new Punto("Punto2", "Punto de Angular", 70.0);
            Punto c = new Punto("Punto3", "Elaboración de documento", 10.0);
            e.addPunto(a);
            e.addPunto(b);
            e.addPunto(c);
            l.setEnunciado(e);
            lab.addLaboratorio(l);
            Grupo grupo = lab.newSala(l, alejandra, "blancoCaicedo").getGrupo("blancoCaicedo");
            grupo.agregarPersona(andres);
            grupo.conectarse(andres);
            grupo.conectarse(alejandra);
            grupo = e.verificar(grupo, c);
            grupo = e.verificar(grupo, a);
            Estudiante cristian = new Estudiante("cristia", 12345);
            Estudiante alex = new Estudiante("alex", 12345);
            lab.addEstudiante(cristian);
            lab.addEstudiante(alex);
            materias.get("ARSW").registrarPersona(personas.get(3));
            materias.get("ARSW").registrarPersona(personas.get(4));
            Grupo grupo1 = lab.newSala(l, cristian, "cc").getGrupo("cc");
            grupo1.agregarPersona(alex);
            grupo1.conectarse(alex);
            grupo1.conectarse(cristian);
        } catch (ExceptionLabNCode ex) {
            Logger.getLogger(ManejadorLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
