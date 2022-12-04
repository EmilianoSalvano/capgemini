package domain.models.entities.productos;

import domain.models.entities.EntidadPersistente;

import java.math.BigDecimal;

abstract class ProductoDecorator extends EntidadPersistente implements iProducto {
    private iProducto producto;

    abstract public BigDecimal precioProducto();


    abstract public String descripcionProducto();
}
