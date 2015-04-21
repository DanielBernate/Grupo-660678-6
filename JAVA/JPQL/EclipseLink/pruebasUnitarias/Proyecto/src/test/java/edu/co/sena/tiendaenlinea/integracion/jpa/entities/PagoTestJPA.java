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
public class PagoTestJPA {
    EntityManager em;
    EntityManagerFactory emf;
    Pago pago1;
    
    public PagoTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pago1 = new Pago();
        pago1.setNumTarCredito("1233454324");
        pago1.setBanco("Banco Popular");
        pago1.setTipoCuentaTar("Ahorros");
        pago1.setTipoTransaccion("Debito");
        pago1.setFacturaidFactura(1);
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
    public void insertarPago() {
       
        em= EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pago1);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
