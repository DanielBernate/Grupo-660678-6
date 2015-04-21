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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria"),
    @NamedQuery(name = "Categoria.findByActiva", query = "SELECT c FROM Categoria c WHERE c.activa = :activa"),
    @NamedQuery(name = "Categoria.findByPariente", query = "SELECT c FROM Categoria c WHERE c.pariente = :pariente")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @Column(name = "nombreCategoria")
    private String nombreCategoria;
    @Basic(optional = false)
    @Column(name = "activa")
    private boolean activa;
    @Basic(optional = false)
    @Column(name = "pariente")
    private int pariente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaidCategoria")
    private List<Producto> productoList;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String nombreCategoria, boolean activa, int pariente) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.activa = activa;
        this.pariente = pariente;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getPariente() {
        return pariente;
    }

    public void setPariente(int pariente) {
        this.pariente = pariente;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.proyecto.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
