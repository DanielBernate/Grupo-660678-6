package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Cuenta;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.DomicilioCuentaPK;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-20T19:51:52")
@StaticMetamodel(DomicilioCuenta.class)
public class DomicilioCuenta_ { 

    public static volatile SingularAttribute<DomicilioCuenta, String> barrio;
    public static volatile SingularAttribute<DomicilioCuenta, Municipio> municipioidMunicipio;
    public static volatile SingularAttribute<DomicilioCuenta, String> direccion;
    public static volatile SingularAttribute<DomicilioCuenta, Cuenta> cuenta;
    public static volatile SingularAttribute<DomicilioCuenta, DomicilioCuentaPK> domicilioCuentaPK;
    public static volatile SingularAttribute<DomicilioCuenta, String> localidad;
    public static volatile SingularAttribute<DomicilioCuenta, String> telefono;

}