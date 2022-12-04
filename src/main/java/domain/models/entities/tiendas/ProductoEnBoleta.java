package domain.models.entities.tiendas;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class ProductoEnBoleta extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    private Publicacion producto;


    @ManyToOne
    @JoinColumn(name="idBoleta", referencedColumnName = "id")
    private Boleta boleta;

    @Column
    private Integer cantidad;
}
