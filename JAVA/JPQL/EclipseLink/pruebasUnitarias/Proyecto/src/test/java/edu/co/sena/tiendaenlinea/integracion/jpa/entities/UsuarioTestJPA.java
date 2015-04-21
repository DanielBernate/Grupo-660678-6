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
public class UsuarioTestJPA {

    Usuario usuario;
    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Usuario();
        usuario.setIdUsuario("dabp");
        usuario.setContrasena("123456");
        usuario.setEstado("Activo");
        usuario.setRol("Cliente");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    //insert
    @Test
    public void insertarUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    //update
    @Test
    public void actualizarUsuario() {

        String usuLeida = JOptionPane.showInputDialog("digite la Usuario para actualizar");
        String usuLeidaValor = JOptionPane.showInputDialog("digite el Estado");

        usuario.setIdUsuario((usuLeida));
        usuario.setEstado((usuLeidaValor));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    //findAll
   @Test
    public void buscarUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Usuario.findAll");
        List<Usuario> lis = q.getResultList();
        for (Usuario usuarioT : lis) {
            System.out.println(usuarioT.getIdUsuario()+ " " + usuarioT.getContrasena());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    //findAll iD
     @Test
    public void buscarUnUsuario() {
        String idUsuario = JOptionPane.showInputDialog("inserte el id a buscar");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Usuario us = em.find(Usuario.class,idUsuario);

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        System.out.println(us.toString());    
    }
    
//    // update Id
//    @Test
//    public void actualizarPkUsuario() {
//        em = EntityManagerHelper.getEntityManager();
//        String viejoId = JOptionPane.showInputDialog("Digite el id que desee actualizar");
//        String nuevoId = JOptionPane.showInputDialog("Digite el nuevo Id");
//        String sql = "UPDATE tiendaenlinea.usuario "
//                + "SET "
//                + "idUsuario = " + nuevoId + " "
//                + "WHERE idUsuario = " +viejoId + ";";
//        System.out.println(sql);
//        Query query = em.createNativeQuery(sql);
//        EntityManagerHelper.beginTransaction();
//        int rowCount = query.executeUpdate();
//        System.out.println("se actualizaron " + rowCount + " registros");
//        EntityManagerHelper.commit();
//        EntityManagerHelper.closeEntityManager();
//        EntityManagerHelper.closeEntityManagerFactory();
//
//    }

}
