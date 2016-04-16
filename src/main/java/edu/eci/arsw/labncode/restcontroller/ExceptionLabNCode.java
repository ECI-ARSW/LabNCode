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

    public ExceptionLabNCode(String message) {
        super(message);
    }
    
    
    
}
