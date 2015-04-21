/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlinea.integracion.jpa.prueba;

import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Categoria;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Catalogo;
import edu.co.sena.tiendaenlinea.integracion.jpa.entities.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ColsutecR
 */
public class CategoriaAPPEclipseLink {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Categoria c1 = new Categoria();
        c1.setIdCategoria(1);
//        c1.setActiva(Boolean.TRUE);
//        c1.setNombreCategoria("Instrumentos");
//        c1.setPariente(1);
       
        Catalogo cat1 = new Catalogo();
//        cat1.setNombreCatalogo("Instrumento musicales");
//        cat1.setDescripcion("intrumentos de todas las clases");
        
//        Producto prod1 = new Producto();
//        prod1.setIdProducto("A001");
//        prod1.setNombre("Guitarra Agustica");
//        prod1.setMaterial("Koa");
//        prod1.setDescuento(0);
//        prod1.setCantidad(5);
//        prod1.setDescripcion("Una clasica Guitarra");
//        prod1.setMarca("Yamaha");
//        prod1.setReferencia("T002");
//        prod1.setPrecioUnitario(1500000);
//        prod1.setActivo(true);
//        prod1.setColor("Negro");
//        prod1.setCatalogoidCatalogo(cat1);
//        prod1.setCategoriaidCategoria(c1);
        
         Producto prod2 = new Producto();
        prod2.setIdProducto("E002");
        prod2.setNombre("Guitarra Electrica");
        prod2.setMaterial("Plastica");
        prod2.setDescuento(0);
        prod2.setCantidad(4);
        prod2.setDescripcion("Una Guitara con un buen sonido");
        prod2.setMarca("Fander");
        prod2.setReferencia("ZA123");
        prod2.setPrecioUnitario(200000);
        prod2.setActivo(true);
        prod2.setColor("Azul");
        prod2.setCatalogoidCatalogo(cat1);
        prod2.setCategoriaidCategoria(c1);
        
        
        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Proyecto_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();

        em1.merge(prod2);

        em1.getTransaction().commit();

        em1.close();
        emf1.close();
    }
    
}
