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
@Table(name = "carritodecompras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carritodecompras.findAll", query = "SELECT c FROM Carritodecompras c"),
    @NamedQuery(name = "Carritodecompras.findByIdCarritoDeCompras", query = "SELECT c FROM Carritodecompras c WHERE c.idCarritoDeCompras = :idCarritoDeCompras"),
    @NamedQuery(name = "Carritodecompras.findBySubtotal", query = "SELECT c FROM Carritodecompras c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Carritodecompras.findByPrecioTotal", query = "SELECT c FROM Carritodecompras c WHERE c.precioTotal = :precioTotal"),
    @NamedQuery(name = "Carritodecompras.findByImpuestos", query = "SELECT c FROM Carritodecompras c WHERE c.impuestos = :impuestos")})
public class Carritodecompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCarritoDeCompras")
    private String idCarritoDeCompras;
    @Basic(optional = false)
    @Column(name = "subtotal")
    private float subtotal;
    @Basic(optional = false)
    @Column(name = "precioTotal")
    private float precioTotal;
    @Basic(optional = false)
    @Column(name = "impuestos")
    private float impuestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritodecompras")
    private List<ItemCarrito> itemCarritoList;

    public Carritodecompras() {
    }

    public Carritodecompras(String idCarritoDeCompras) {
        this.idCarritoDeCompras = idCarritoDeCompras;
    }

    public Carritodecompras(String idCarritoDeCompras, float subtotal, float precioTotal, float impuestos) {
        this.idCarritoDeCompras = idCarritoDeCompras;
        this.subtotal = subtotal;
        this.precioTotal = precioTotal;
        this.impuestos = impuestos;
    }

    public String getIdCarritoDeCompras() {
        return idCarritoDeCompras;
    }

    public void setIdCarritoDeCompras(String idCarritoDeCompras) {
        this.idCarritoDeCompras = idCarritoDeCompras;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    @XmlTransient
    public List<ItemCarrito> getItemCarritoList() {
        return itemCarritoList;
    }

    public void setItemCarritoList(List<ItemCarrito> itemCarritoList) {
        this.itemCarritoList = itemCarritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarritoDeCompras != null ? idCarritoDeCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carritodecompras)) {
            return false;
        }
        Carritodecompras other = (Carritodecompras) object;
        if ((this.idCarritoDeCompras == null && other.idCarritoDeCompras != null) || (this.idCarritoDeCompras != null && !this.idCarritoDeCompras.equals(other.idCarritoDeCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.proyecto.Carritodecompras[ idCarritoDeCompras=" + idCarritoDeCompras + " ]";
    }
    
}
