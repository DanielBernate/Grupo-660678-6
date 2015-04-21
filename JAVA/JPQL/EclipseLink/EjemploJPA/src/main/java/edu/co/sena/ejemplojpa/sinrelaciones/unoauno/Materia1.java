/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa.sinrelaciones.unoauno;

import edu.co.sena.ejemplojpa.anotaciones.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "MATERIA1")
public class Materia1 implements Serializable {

    @Id
    @Column(name = "ID_MATERIA")
    private int idMateria;
    
    @Column (name = "NOMBRE_MATERIA")
    private String nombre;
    
    @Column (name = "DIRIGIDA")
    private String dirigida;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirigida() {
        return dirigida;
    }

    public void setDirigida(String dirigida) {
        this.dirigida = dirigida;
    }

}
