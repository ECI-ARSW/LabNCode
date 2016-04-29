/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.restcontroller;

/**
 *
 * @author Andres
 */
public class ExceptionLabNCode extends Exception{
    public final static String NoExisteEnSala="No existe estudiante en la sala" ;
    public final static String ConectadoEnSala="Existe al menos un conectado en la sala" ;
    public final static String EstudianteOtraMateria="El estudiante no esta en la materia" ;
    public final static String EstudianteInexistente="El estudiante no existe";
    public final static String ProfesorInexistente="El profesor no existe";
    public final static String NoEsProfesor="Esta persona no es un profesor";
    public final static String NoEsEstudiante="Esta persona no es un estudiante";
    public ExceptionLabNCode(String message) {
        super(message);
    }
    
    
    
}
