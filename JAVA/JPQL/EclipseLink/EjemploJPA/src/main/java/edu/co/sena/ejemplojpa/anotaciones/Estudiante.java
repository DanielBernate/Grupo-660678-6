/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa.anotaciones;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "ESTUDIANTE" ,indexes ={@Index (name = "pruebaIndice",columnList = "NOMBREESTUDIANTE,IDESTUDIANTE" )})
public class Estudiante implements Serializable {

    @Id
    @Column (name = "IDESTUDIANTE")
    private String idEstudiante;

    @Column(name = "NOMBRE_ESTUDIANTE", nullable = false)
    private String nombre;
    
    @Column(name = "APELLIDOS_ESTUDIANTE")
    private String apellido;
    
    @Column (name = "EMAIL", nullable = false, length = 200)
    private String email;
    
    @Column(name = "EDAD")
    private int edad;
    
    

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
