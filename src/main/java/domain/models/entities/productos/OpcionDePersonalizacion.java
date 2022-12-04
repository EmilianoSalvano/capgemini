package domain.models.entities.productos;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
public class OpcionDePersonalizacion extends EntidadPersistente {
    private String nombre;

    private String atributo;
}
