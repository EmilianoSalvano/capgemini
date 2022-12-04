package domain.models.entities.tiendas;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Comprador extends EntidadPersistente {
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Usuario usuario;
}
