package domain.models.entities.tiendas;

import domain.models.entities.EntidadPersistente;
import domain.models.entities.productos.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Publicacion extends EntidadPersistente {

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPosiblePublicacion estadoActual;

    @OneToOne
    private ProductoPersonalizado producto;
}
