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
public class ItemCarritoTestJPA {
    EntityManager em;
    EntityManagerFactory emf;
    ItemCarrito itemCarrito;
    
    public ItemCarritoTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        itemCarrito = new ItemCarrito();
        itemCarrito.setCantidad(5);
        itemCarrito.setCostoUnitario(150000);
        itemCarrito.setCostoTotal(5000000);
        itemCarrito.setItemCarritoPK(new ItemCarritoPK("A001", "001"));
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
    public void insertarCategoria() {
       
        em= EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(itemCarrito);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
