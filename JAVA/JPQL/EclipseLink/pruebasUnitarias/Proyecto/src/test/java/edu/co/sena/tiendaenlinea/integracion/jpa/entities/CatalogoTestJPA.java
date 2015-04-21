/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
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
public class CatalogoTestJPA {

    Catalogo catalogo;
    EntityManager em;

    public CatalogoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        catalogo = new Catalogo();
        catalogo.setIdCatalogo(1);
        catalogo.setNombreCatalogo("Instrumentos Musicales");
        catalogo.setDescripcion("Contendran todas las clases de instrumentos");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
   
    // insert
    @Test
    public void insertarCatalogo() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(catalogo);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    // Update
    @Test
    public void actualizarCatalogo() {

        String catLeida = JOptionPane.showInputDialog("digite la caegoria a actualizar");
        String catLeidaValor = JOptionPane.showInputDialog("digite el nombre");

        catalogo.setIdCatalogo(Integer.parseInt(catLeida));
        catalogo.setNombreCatalogo(catLeidaValor);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(catalogo);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    //findhy All
    @Test
    public void buscarCatalogo() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Catalogo.findAll");
        List<Catalogo> lis = q.getResultList();
        for (Catalogo catalogoT : lis) {
            System.out.println(catalogoT.getIdCatalogo() + " " + catalogoT.getNombreCatalogo());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    // find ID
    
       @Test
    public void buscarUnaCatalogo() {
        String idCatalogo = JOptionPane.showInputDialog("inserte el id a buscar");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Catalogo ct = em.find(Catalogo.class, Integer.parseInt(idCatalogo));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        System.out.println(ct.toString());    
    }
    
    

    //Delete
    @Test
    public void eliminarTodasLasCatalogo() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query q = em.createNamedQuery("Catalogo.findAll");
        List<Catalogo> lis = q.getResultList();

        for (Catalogo catalogoT : lis) {
            em.remove(em.find(Catalogo.class, catalogoT.getIdCatalogo()));
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

}
