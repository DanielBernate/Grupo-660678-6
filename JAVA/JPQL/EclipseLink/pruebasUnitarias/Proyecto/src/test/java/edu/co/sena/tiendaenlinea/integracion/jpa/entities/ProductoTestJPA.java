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
public class ProductoTestJPA {

    Producto producto;
    EntityManagerFactory emf;
    EntityManager em;

    public ProductoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        producto = new Producto();
        producto.setIdProducto("A001");
        producto.setNombre("Guitarra Acustica");
        producto.setMarca("Yamaha");
        producto.setMaterial("Koa");
        producto.setReferencia("T0012");
        producto.setDescuento(0);
        producto.setActivo(true);
        producto.setPrecioUnitario(1500000);
        producto.setCatalogoidCatalogo(new Catalogo(1));
        producto.setCategoriaidCategoria(new Categoria(1000));
        producto.setColor("negro");
        producto.setDescripcion("Es una guitarra clasica");
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
    public void insertarProducto() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    // update  

    @Test
    public void actualizarProducto() {

        String proLeida = JOptionPane.showInputDialog("digite el producto a actualizar");
        String proLeidaValor = JOptionPane.showInputDialog("digite el nombre");

        producto.setIdProducto(proLeida);
        producto.setNombre(proLeidaValor);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    //findhy Id
        @Test
    public void buscarUnProducto() {
        String idproducto = JOptionPane.showInputDialog("inserte el id a buscar del producto");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Producto pro = em.find(Producto.class,idproducto);

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        System.out.println(pro.toString());    
    }
    
// findAll
    @Test
    public void buscarProducto() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findAll");
        List<Producto> lis = q.getResultList();
        for (Producto productoT : lis) {
            System.out.println(productoT.getIdProducto()+ " " + productoT.getNombre());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    //delete
     @Test
    public void eliminarUnProducto() {
        String idProducto = JOptionPane.showInputDialog("inserte el id del producto que desee borrar");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.remove(em.find(Producto.class,idProducto));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

}
