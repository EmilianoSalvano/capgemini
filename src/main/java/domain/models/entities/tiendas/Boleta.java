package domain.models.entities.tiendas;

import com.sun.istack.internal.NotNull;
import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Boleta extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "idTienda", referencedColumnName = "id")
    private TiendaVendedor tienda;

    @ManyToOne
    @JoinColumn(name = "idComprador", referencedColumnName = "id")
    private Comprador comprador;


    @Enumerated(EnumType.STRING)
    @Column(name = "estadoBoleta")
    @NotNull
    private EstadoPosibleBoleta estado;
}
