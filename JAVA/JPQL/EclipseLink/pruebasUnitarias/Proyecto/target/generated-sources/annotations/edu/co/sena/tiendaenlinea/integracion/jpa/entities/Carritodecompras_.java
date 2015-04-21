package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.entities.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-20T19:51:51")
@StaticMetamodel(Carritodecompras.class)
public class Carritodecompras_ { 

    public static volatile ListAttribute<Carritodecompras, ItemCarrito> itemCarritoList;
    public static volatile SingularAttribute<Carritodecompras, Float> subtotal;
    public static volatile SingularAttribute<Carritodecompras, Float> impuestos;
    public static volatile SingularAttribute<Carritodecompras, Float> precioTotal;
    public static volatile SingularAttribute<Carritodecompras, String> idCarritoDeCompras;

}