package domain.models.entities.tiendas;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MetodoDePago")
@Getter
@Setter
public class MetodoDePago extends EntidadPersistente {
    @Column
    private MetodoDePagoPosible metodo;

    @Column
    private String CBU_CVU;

    @Column
    private String alias;

    @ManyToOne
    @JoinColumn(name = "idTienda", referencedColumnName = "id")
    private TiendaVendedor tienda;
}
