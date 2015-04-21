/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class ProvedorTesTJPA {

    Proveedor proveedor;
    EntityManagerFactory emf;
    EntityManager em;

    public ProvedorTesTJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        proveedor = new Proveedor();
        proveedor.setProveedorPK(new ProveedorPK("instr", "CC"));
        proveedor.setEmail("instruc");
        proveedor.setNombre("intrumentos s.a");
        proveedor.setTelefono("3132742589");

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
    public void insertarProveedor() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(proveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
      //Update
    @Test
    public void actualizarProveedor() {

        String proveIdtLeida = JOptionPane.showInputDialog("digite el idProveedor a actualizar");
        String proveTpLeida = JOptionPane.showInputDialog("digite el tipo de documento a actualizar");
        String catLeidaValor = JOptionPane.showInputDialog("digite el nuevo Nombre ");
        proveedor.setProveedorPK(new ProveedorPK(proveTpLeida, proveIdtLeida));
        proveedor.setNombre(catLeidaValor);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(proveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    // findhyId
    @Test
    public void buscarUnProveedor() {
        String idProveedor = JOptionPane.showInputDialog("inserte el idProveedor a buscar");
        String idTipoDocumeto = JOptionPane.showInputDialog("inserte tipo de documento a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Proveedor pro = em.find(Proveedor.class, new ProveedorPK(idProveedor, idTipoDocumeto));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(pro.toString());
    }

    // delete
    @Test
    public void eliminarProveedor() {
        String idProveedor = JOptionPane.showInputDialog("inserte el idProveedor a borrar");
        String idTipoDocumento = JOptionPane.showInputDialog("inserte el tipo de documento a borrar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Proveedor.class, new ProveedorPK(idProveedor, idTipoDocumento)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
}
