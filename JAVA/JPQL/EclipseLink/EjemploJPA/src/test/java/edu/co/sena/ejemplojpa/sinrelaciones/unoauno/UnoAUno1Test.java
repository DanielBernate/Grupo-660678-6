/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa.sinrelaciones.unoauno;

import edu.co.sena.ejemplojpa.relaciones.unoauno.*;
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
public class UnoAUno1Test {
    
    public UnoAUno1Test() {
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
        Estudiante2 est = new Estudiante2();
        est.setIdEstudiante("12349dsf");
        est.setNombre("Daniel");
        est.setApellido("Bernate");
        est.setEmail("dabernate@misena");
        est.setEdad(18);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
        @Test
    public void insertarMateria() {
        Materia2 mater = new Materia2();
        mater.setIdMateria(1452);
        mater.setNombre("Trigonometria");
        mater.setDirigida("Sandra Cardona");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(mater);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
