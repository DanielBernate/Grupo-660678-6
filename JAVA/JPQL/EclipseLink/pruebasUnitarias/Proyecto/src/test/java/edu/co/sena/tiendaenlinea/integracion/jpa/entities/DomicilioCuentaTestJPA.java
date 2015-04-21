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
public class DomicilioCuentaTestJPA {

    DomicilioCuenta domicilioCuenta;
    EntityManagerFactory emf;
    EntityManager em;

    public DomicilioCuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        domicilioCuenta = new DomicilioCuenta();
        domicilioCuenta.setDomicilioCuentaPK(new DomicilioCuentaPK("CC", "1023008273"));
        domicilioCuenta.setTelefono("3132742589");
        domicilioCuenta.setLocalidad("18 rafael uribe");
        domicilioCuenta.setBarrio("Molinos");
        domicilioCuenta.setMunicipioidMunicipio(new Municipio("1"));
        domicilioCuenta.setDireccion("Calle 48R- 3D");

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
    public void insertarDomicilioCuenta() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domicilioCuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    //Update
    @Test
    public void actualizarDomicilioCuenta() {

        String domcueTtLeida = JOptionPane.showInputDialog("digite el tipo de documento a actualizar");
        String domcueNLeida = JOptionPane.showInputDialog("digite el numrto de documento a actualizar");
        String catLeidaValor = JOptionPane.showInputDialog("digite el nuevo barrio ");
        domicilioCuenta.setDomicilioCuentaPK(new DomicilioCuentaPK(domcueTtLeida, domcueNLeida));
        domicilioCuenta.setBarrio(catLeidaValor);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(domicilioCuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    // findhyId
    @Test
    public void buscarUnaDomicilioCuenta() {
        String idTipoDocumeto = JOptionPane.showInputDialog("inserte tipo de documento a buscar");
        String idNumeroDocumeto = JOptionPane.showInputDialog("inserte numero de documento a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        DomicilioCuenta dc = em.find(DomicilioCuenta.class, new DomicilioCuentaPK(idTipoDocumeto, idNumeroDocumeto));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(dc.toString());
    }

    // delete
    @Test
    public void eliminarDomicilioCuenta() {
        String idTipoDocumento = JOptionPane.showInputDialog("inserte el Tipo documento a borrar");
        String idNumeroDocumento = JOptionPane.showInputDialog("inserte el numero documento a borrar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(DomicilioCuenta.class, new DomicilioCuentaPK(idTipoDocumento, idNumeroDocumento)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
