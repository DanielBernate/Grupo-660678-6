package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Departamento;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.DomicilioCuenta;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.DomicilioProveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-20T19:51:51")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> idMunicipio;
    public static volatile ListAttribute<Municipio, DomicilioProveedor> domicilioProveedorList;
    public static volatile SingularAttribute<Municipio, String> nombre;
    public static volatile ListAttribute<Municipio, DomicilioCuenta> domicilioCuentaList;
    public static volatile SingularAttribute<Municipio, Departamento> departamentoidDepartamento;

}