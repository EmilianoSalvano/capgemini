package domain.models.entities.productos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Personalizacion")
@Setter
@Getter
public class Personalizacion extends ProductoDecorator {
    @Column
    private String descripcion;

    @OneToOne
    private OpcionDePersonalizacion opcionDePersonalizacion;

    @OneToOne
    private AreaDePersonalizacion areaDePersonalizacion;

    @Column
    private BigDecimal precio;

    @Transient
    private iProducto producto;     //Esto es el producto con las personalizaciones aplicadas.

    @ManyToOne
    @JoinColumn(name = "productoPersonalizado")
    private ProductoPersonalizado productoPersonalizado;

    @Override
    public BigDecimal precioProducto(){
        return producto.precioProducto().add(this.precio);
    }

    public String descripcionProducto(){
        return producto.descripcionProducto() + "\n" + this.descripcion;
    }
}
