/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.entities;

import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
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
public class CuentaTestJPA {

    Cuenta cuenta;
    EntityManagerFactory emf;
    EntityManager em;

    public CuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cuenta = new Cuenta();
        cuenta.setCuentaPK(new CuentaPK("CC", "1023008273"));
        cuenta.setPrimerNombre("Daniel");
        cuenta.setSegundoNombre("Alejandro");
        cuenta.setPrimerApellido("Bernate");
        cuenta.setSegundoApellido("Penuela");
        cuenta.setEmail("dabernate@misena");
        cuenta.setContrasena("123456");
        cuenta.setUsuarioidUsuario(new Usuario("dabp"));
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
    public void insertarCuenta() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    //update
    @Test
    public void actualizarCuenta() {

        String cueLeida = JOptionPane.showInputDialog("digite el tipo documento actualizar");
        String cue2Leida = JOptionPane.showInputDialog("Digite el numero de documento actualizar");
        String cueLeidaValor = JOptionPane.showInputDialog("digite el Nombre");

        cuenta.setCuentaPK(new CuentaPK(cueLeida, cue2Leida));

        cuenta.setPrimerNombre(cueLeidaValor);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    //findAL Id
    @Test
    public void buscarUnaCuenta() {
        String idCuenta1 = JOptionPane.showInputDialog("inserte el tipo de documento");
        String idCuenta2 = JOptionPane.showInputDialog("inserte el numero de documento");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Cuenta cue = em.find(Cuenta.class, new CuentaPK(idCuenta1, idCuenta2));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(cue.toString());

    }

    //    // update Id
    @Test
    public void actualizarPkCuenta() {
        em = EntityManagerHelper.getEntityManager();
        String viejoTipoDoc = JOptionPane.showInputDialog("Digite el tipo de documentar que desee actualizar");
        String viejoNumeroDoc = JOptionPane.showInputDialog("Digite el numero de documentar que desee actualizar");
        String nuevoTipoDoc = JOptionPane.showInputDialog("Digite el nuevo tipo documento");
        String nuevoNumeroDoc = JOptionPane.showInputDialog("Digite el nuevo numero documento");

        String sql = "UPDATE tiendaenlinea.cuenta"
                + "SET "
                + "tipoDocumento = " + nuevoTipoDoc + " ,"
                + "numeroDocumento = " + nuevoNumeroDoc + " ,"
                + "WHERE tipoDocumento =" + viejoTipoDoc + "AND numeroDocumento = " + viejoNumeroDoc + " ;";
        System.out.println(sql);
        Query query = em.createNativeQuery(sql);
        EntityManagerHelper.beginTransaction();
        int rowCount = query.executeUpdate();
        System.out.println("se actualizaron " + rowCount + " registros");
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    
    

}
