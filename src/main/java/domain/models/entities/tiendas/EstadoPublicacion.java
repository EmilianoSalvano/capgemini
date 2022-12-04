package domain.models.entities.tiendas;

import com.sun.istack.internal.NotNull;
import domain.models.entities.EntidadPersistente;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EstadoPublicacion")
@Getter                                                 //No uso setter porque no quiero que se puedan cambiar
public class EstadoPublicacion extends EntidadPersistente {

    //LocalDate no tiene una transformacion directa del ORM, asi que la tengo que traducir a DATE,
    //los "traductores" estan en la carpeta converters. En este caso lo hago de forma IMPLICITA, el ORM
    //va a buscar en converters algun conversor "LocalDate - Date" que tenga el "autoApply = true"
    @Column(name = "FechaCambio", columnDefinition = "DATE")
    private LocalDate FechaCambio;

    @Enumerated(EnumType.STRING)                            //En la tabla de la db se guarda como el nombre del Enum en lugar de su numero.
    @Column(name = "EstadoDePublicacion")
    @NotNull
    private EstadoPosiblePublicacion Estado;

    @ManyToOne
    @JoinColumn(name = "idPublicacion", referencedColumnName = "id")
    @NotNull
    private Publicacion publicacion;


    public EstadoPublicacion(EstadoPosiblePublicacion Estado){
        this.Estado = Estado;
        FechaCambio = LocalDate.now();
    }

    public EstadoPublicacion() {
        FechaCambio = LocalDate.now();
    }
}
