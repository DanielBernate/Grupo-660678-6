/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplojpa;

import edu.co.sena.ejemplojpa.anotaciones.Estudiante;
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
 * @author ColsutecR
 */
public class EstudianteAPP {

    public EstudianteAPP() {
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
        Estudiante e1 = new Estudiante();
        e1.setIdEstudiante("123456789");
        e1.setNombre("Daniel");
        e1.setApellido("Bernate");
        e1.setEmail("dabernate@misena");
        e1.setEdad(18);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.co.sena.Ejemplo.UnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
        @Test
    public void insertarMateria() {
        Materia mate1 = new Materia();
        mate1.setIdMateria(147);
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
