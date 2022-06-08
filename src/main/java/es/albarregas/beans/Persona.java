/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jesus
 */
public class Persona implements Serializable {
    
    private String nombre;
    private String apellidos;
    private String dni;
    private Byte numHer;
    private Date fecha;
    private List<String> aficiones;

    public Persona() {
        
    }
    
    public Persona(String nombre, String apellidos, String dni, Byte numHer, Date fecha, List<String> aficiones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numHer = numHer;
        this.fecha = fecha;
        this.aficiones = aficiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Byte getNumHer() {
        return numHer;
    }

    public void setNumHer(Byte numHer) {
        this.numHer = numHer;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }
    
    
}
