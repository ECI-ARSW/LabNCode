/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.labncode.service;

import edu.eci.arsw.labncode.model.Laboratorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MaríaAlejandra
 */
@RestController
@RequestMapping("/rest/laboratorio")
public class RestLaboratorio {
    @Autowired 
    Laboratorio lab; 
    //creacion de la sala
    //creacion de la laboratorio
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> persist(@RequestBody Laboratorio lab) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
