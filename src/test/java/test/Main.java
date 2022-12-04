package test;

import domain.db.EntityManagerHelper;
import domain.models.entities.productos.AreaDePersonalizacion;
import domain.models.entities.productos.ProductoBase;
import domain.models.entities.tiendas.Usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        cargarProductosBase();

        ProductoBase unProductoBase = EntityManagerHelper.getEntityManager().find(ProductoBase.class, 1);

        System.out.println(unProductoBase == null ? "NADA" : (unProductoBase.getNombre() + ": " + unProductoBase.descripcionProducto()));
    }


    private static void cargarProductosBase(){
        List<AreaDePersonalizacion> areasDePersonalizacion1 = new ArrayList<AreaDePersonalizacion>(){
            {
                add(new AreaDePersonalizacion("Frente"));
                add(new AreaDePersonalizacion("Manga"));
                add(new AreaDePersonalizacion("Espalda"));
            }
        };
        List<AreaDePersonalizacion> areasDePersonalizacion2 = new ArrayList<AreaDePersonalizacion>(){
            {
                add(new AreaDePersonalizacion("Frente"));
                add(new AreaDePersonalizacion("Espalda"));
            }
        };
        List<AreaDePersonalizacion> areasDePersonalizacion3 = new ArrayList<AreaDePersonalizacion>() {
            {
                add(new AreaDePersonalizacion("Frente"));
            }
        };
        List<AreaDePersonalizacion> areasDePersonalizacion4 = new ArrayList<AreaDePersonalizacion>(){
            {
                add(new AreaDePersonalizacion("Manga"));
                add(new AreaDePersonalizacion("Espalda"));
            }
        };

        ProductoBase producto1 = new ProductoBase("Remera 1", "Remera manga larga con cuello v",
                new BigDecimal(550.25),15, areasDePersonalizacion1);
        ProductoBase producto2 = new ProductoBase("Remera 2", "Remera manga corta con cuello v",
                new BigDecimal(500),15, areasDePersonalizacion2);
        ProductoBase producto3 = new ProductoBase("Gorra", "Gorra con ajuste de velcro",
                new BigDecimal(200),10, areasDePersonalizacion3);
        ProductoBase producto4 = new ProductoBase("Campera", "Campera con capucha",
                new BigDecimal(800),10, areasDePersonalizacion4);

        List<ProductoBase> listaProductos = new ArrayList<ProductoBase>(){
            {
                add(producto1);
                add(producto2);
                add(producto3);
                add(producto4);
            }
        };

        EntityManagerHelper.beginTransaction();

        //GENERO la sentencia insert, NO LA EJECUTO
        listaProductos.forEach(producto -> EntityManagerHelper.getEntityManager().persist(producto));

        EntityManagerHelper.commit();
    }
}
