/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class CategoriaTestJJPA {

    Categoria categoria;
    EntityManager em;
    EntityManagerFactory emf;

    public CategoriaTestJJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        categoria = new Categoria();
        categoria.setIdCategoria(1000);
        categoria.setNombreCategoria("categoria de prueba");
        categoria.setPariente(5);
        categoria.setActiva(true);

      
    }

    @After
    public void tearDown() {
    
    }
// Insertar
    @Test
    public void insertarCategoria() {
       
        em= EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    //Update
    
      @Test
    public void actualizarCategoria() {

        String catLeida = JOptionPane.showInputDialog("digite la categoria a actualizar");
        String catLeidaValor = JOptionPane.showInputDialog("digite el nombre de la categoria");

        categoria.setIdCategoria(Integer.parseInt(catLeida));
        categoria.setNombreCategoria(catLeidaValor);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    // findhyId
    
        @Test
    public void buscarUnaCategoria() {
        String idCategoria = JOptionPane.showInputDialog("inserte el id a buscar");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Categoria ct = em.find(Categoria.class, Integer.parseInt(idCategoria));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        System.out.println(ct.toString());    
    }
    
    // findhy All
       @Test
    public void buscarCategorias() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Categoria.findAll");
        List<Categoria> lis = q.getResultList();
        for (Categoria categoriaT : lis) {
            System.out.println(categoriaT.getIdCategoria() + " " + categoriaT.getNombreCategoria());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    // delete
    @Test
    public void eliminarUnaCategoria() {
        String idCategoria = JOptionPane.showInputDialog("inserte el id a borrar");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.remove(em.find(Categoria.class, Integer.parseInt(idCategoria)));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
