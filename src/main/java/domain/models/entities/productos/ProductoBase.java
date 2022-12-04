package domain.models.entities.productos;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

//NOTA: como ahora hereda de "EntidadPersistente" el id ya viene herdadp de ahi.
@Entity                                         //Dice que es una entidad
@Table(name = "ProductoBase")                   //Le dice al ORM que esta entidad tiene que estar persistida en la BD con el nombre "ProductoBase"
                                                //Si no se indica el nombre usa el nombre de la clase (Servicio)
@Setter                                         //Le pone setter y getter a todos los parametros
@Getter
public class ProductoBase extends EntidadPersistente {
//    @Id                                         //Este campo "id" es un ID de la tabla "ProductoBase"
//    @GeneratedValue                             //Este ID es generado automaticamente (va incrementando de a 1)
//    private Integer id;

    public ProductoBase(String nombre, String descripcion, BigDecimal precio, Integer tiempoFabricacion, List<AreaDePersonalizacion> areasDePersonalizacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoFabricacion = tiempoFabricacion;
        this.areasDePersonalizacion = areasDePersonalizacion;
    }

    public ProductoBase(){
        areasDePersonalizacion = new ArrayList<>();
    }

    @Column(name = "nombre")                    //Indica que el campo "nombre" es una columna de la tabla
    private String nombre;

    @Column(name = "descripcion")               //@Column(name = "descripcion", columnDefinition = "TEXT") si quisiera darle un tipo de dato a la columna
                                                //en la bd que no sea el que va por defecto.
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "tiempoFabricacion")
    private Integer tiempoFabricacion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idProductoBase", referencedColumnName = "id")
    private List<AreaDePersonalizacion> areasDePersonalizacion;

    public BigDecimal precioProducto(){
        return precio;
    }

    public String descripcionProducto(){
        return descripcion;
    }
}

