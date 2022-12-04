package domain.models.entities.tiendas;

import domain.models.entities.EntidadPersistente;
import domain.models.entities.productos.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tienda")
@Getter
@Setter
public class TiendaVendedor extends EntidadPersistente{

    @Column
    private String nombre;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Usuario usuario;

    @OneToMany(mappedBy = "tienda")
    private List<MetodoDePago> metodosDePago;

    @OneToMany(mappedBy = "tienda")
    private List<ProductoPersonalizado> productosPersonalizados;

    public TiendaVendedor(){
        metodosDePago = new ArrayList<MetodoDePago>();
        productosPersonalizados = new ArrayList<ProductoPersonalizado>();
    }
}
