package domain.models.entities.productos;

import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AreaDePersonalizacion")
@Setter
@Getter
public class AreaDePersonalizacion extends EntidadPersistente {

    public AreaDePersonalizacion(String nombre) {
        this.nombre = nombre;
    }

    public AreaDePersonalizacion(){}

    @Column(name = "nombre")
    private String nombre;
}
