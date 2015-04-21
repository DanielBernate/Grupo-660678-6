/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.ejercicio1;

import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Catalogo;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Categoria;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Departamento;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Municipio;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Producto;
import edu.co.sena.tiendaenlinea.integracion.jpa.util.EntityManagerHelper;
import java.util.ArrayList;
import java.util.List;
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
public class CategoriaJPA {

    EntityManager em;
    EntityManagerFactory emf;
    Categoria cate;
    List<Producto> productos;
    Producto produc4;

    public CategoriaJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cate = new Categoria();
        cate.setIdCategoria(1);
        cate.setNombreCategoria("categoria de prueba");
        cate.setPariente(5);
        cate.setActiva(true);
        productos = new ArrayList<>();
        Producto producto1;
        producto1 = new Producto();
        producto1.setIdProducto("A001");
        producto1.setNombre("Guitarra Acustica");
        producto1.setMarca("Yamaha");
        producto1.setMaterial("Koa");
        producto1.setReferencia("T0012");
        producto1.setDescuento(0);
        producto1.setActivo(true);
        producto1.setPrecioUnitario(1500000);
        producto1.setCatalogoidCatalogo(new Catalogo(1, "abc", "abc"));
        producto1.setCategoriaidCategoria(cate);
        producto1.setColor("negro");
        producto1.setDescripcion("Es una guitarra clasica");

        Producto producto2;
        producto2 = new Producto();
        producto2.setIdProducto("A003");
        producto2.setNombre("Guitarra Acustica");
        producto2.setMarca("Yamaha");
        producto2.setMaterial("Koa");
        producto2.setReferencia("T0012");
        producto2.setDescuento(0);
        producto2.setActivo(true);
        producto2.setPrecioUnitario(1500000);
        producto2.setCatalogoidCatalogo(new Catalogo(1, "abc", "abc"));
        producto2.setCategoriaidCategoria(cate);
        producto2.setColor("negro");
        producto2.setDescripcion("Es una guitarra clasica");

        Producto producto3;
        producto3 = new Producto();
        producto3.setIdProducto("A002");
        producto3.setNombre("Guitarra Acustica");
        producto3.setMarca("Yamaha");
        producto3.setMaterial("Koa");
        producto3.setReferencia("T0012");
        producto3.setDescuento(0);
        producto3.setActivo(true);
        producto3.setPrecioUnitario(1500000);
        producto3.setCatalogoidCatalogo(new Catalogo(1, "abc", "abc"));
        producto3.setCategoriaidCategoria(cate);
        producto3.setColor("negro");
        producto3.setDescripcion("Es una guitarra clasica");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        produc4 = new Producto();
        produc4.setIdProducto("A006");
        produc4.setNombre("Guitarra Acustica");
        produc4.setMarca("Yamaha");
        produc4.setMaterial("Koa");
        produc4.setReferencia("T0012");
        produc4.setDescuento(0);
        produc4.setActivo(true);
        produc4.setPrecioUnitario(1500000);
        produc4.setCatalogoidCatalogo(new Catalogo(1, "abc", "abc"));
        produc4.setCategoriaidCategoria(new Categoria(12, "Hola", true, 0));
        produc4.setColor("negro");
        produc4.setDescripcion("Es una guitarra clasica");

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
    public void IsertarCategoriaejem() {
        cate.setProductoList(productos);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(cate);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void IsertarProducto() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(produc4);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarMunicipiosPorDepartamentos() {
        String idDepartamento = JOptionPane.showInputDialog("inserte el id del Departamento ");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Departamento dpt = em.find(Departamento.class, idDepartamento);

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        List<Municipio> munici = dpt.getMunicipioList();
        for (Municipio munici1 : munici) {
            System.out.println(munici.toString());
        }

    }
    
}
