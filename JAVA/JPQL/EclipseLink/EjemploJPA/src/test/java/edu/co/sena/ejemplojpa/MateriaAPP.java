/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa;

import edu.co.sena.ejemplojpa.anotaciones.Materia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class MateriaAPP {
    
    public MateriaAPP() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
    public void insertarMateria() {
        Materia mate1 = new Materia();
        mate1.setIdMateria(123);
        mate1.setNombre("Trigonometria");
        mate1.setDirigida("Sandra Cardona");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(mate1);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
