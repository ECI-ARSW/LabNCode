/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.entidad;

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
}
