/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa.relaciones.unoauno;

import edu.co.sena.ejemplojpa.anotaciones.Estudiante;
import edu.co.sena.ejemplojpa.anotaciones.Materia;
import edu.co.sena.ejemplojpa.sinrelaciones.unoauno.Estudiante1;
import edu.co.sena.ejemplojpa.sinrelaciones.unoauno.Materia1;
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
 * @author ColsutecR
 */
public class UnoAUnoTest {
    
    public UnoAUnoTest() {
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
    public void insertarEstudiante() {
        Estudiante1 es = new Estudiante1();
        es.setIdEstudiante("12349");
        es.setNombre("Daniel");
        es.setApellido("Bernate");
        es.setEmail("dabernate@misena");
        es.setEdad(18);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(es);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
        @Test
    public void insertarMateria() {
        Materia1 mate = new Materia1();
        mate.setIdMateria(1452396);
        mate.setNombre("Trigonometria");
        mate.setDirigida("Sandra Cardona");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(mate);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
