/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNATE
 */
public class DomicilioProveedorTestJPA {
    EntityManager em;
    EntityManagerFactory emf;
    DomicilioProveedor domicilioprove;
    
    public DomicilioProveedorTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        domicilioprove = new DomicilioProveedor();
        domicilioprove.setBarrio("Santa Lucia");
        domicilioprove.setDireccion("Calles 55 # 13-12 sur");
        domicilioprove.setTelefono("3132742589");
        domicilioprove.setMunicipioidMunicipio(new Municipio("12"));
        domicilioprove.setDomicilioProveedorPK( new DomicilioProveedorPK("instr", "CC"));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
        @Test
    public void insertarDomicilioProveedor() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domicilioprove);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
