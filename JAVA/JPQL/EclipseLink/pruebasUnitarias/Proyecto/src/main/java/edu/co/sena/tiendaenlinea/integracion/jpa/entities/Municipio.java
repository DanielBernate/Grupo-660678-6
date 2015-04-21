/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BERNATE
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMunicipio")
    private String idMunicipio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "Departamento_idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne(optional = false)
    private Departamento departamentoidDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioidMunicipio")
    private List<DomicilioCuenta> domicilioCuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioidMunicipio")
    private List<DomicilioProveedor> domicilioProveedorList;

    public Municipio() {
    }

    public Municipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipio(String idMunicipio, String nombre) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamentoidDepartamento() {
        return departamentoidDepartamento;
    }

    public void setDepartamentoidDepartamento(Departamento departamentoidDepartamento) {
        this.departamentoidDepartamento = departamentoidDepartamento;
    }

    @XmlTransient
    public List<DomicilioCuenta> getDomicilioCuentaList() {
        return domicilioCuentaList;
    }

    public void setDomicilioCuentaList(List<DomicilioCuenta> domicilioCuentaList) {
        this.domicilioCuentaList = domicilioCuentaList;
    }

    @XmlTransient
    public List<DomicilioProveedor> getDomicilioProveedorList() {
        return domicilioProveedorList;
    }

    public void setDomicilioProveedorList(List<DomicilioProveedor> domicilioProveedorList) {
        this.domicilioProveedorList = domicilioProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.proyecto.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
