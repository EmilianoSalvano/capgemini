package domain.models.entities.tiendas;

import domain.converters.LocalDateConverter;
import domain.models.entities.EntidadPersistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

//La idea de esta clase es que contenga la informacion necesaria para que un vendedor, comprador y administrador se puedan loguear.
@Entity
@Table
@Setter
@Getter
public class Usuario extends EntidadPersistente {

    @Column
    private String cuitCuil;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Convert(converter = LocalDateConverter.class)      //Uso el converter de forma explicita, no es necesario pero sirve de ejemplo.
    private LocalDate fechaNacimiento;

    //va a haber una nueva tabla de nombre emailUsuario, con una columna usuarioId que tiene clave foranea
    //a la tabla usuario.
    @ElementCollection
    @CollectionTable(name = "emailUsuario", joinColumns = @JoinColumn(name = "usuarioId"))
    @Column(name = "email")                             //Nombre de columna de en la tabla emailUsuario

    private Set<String> emails;                          //Es una INTERFAZ de coleccion sin elementos repetidos ni ordenados.
                                                        //List tambien es una interfaz. Ambas necesitan ser inicializadas
                                                        //con un objeto que las implemente.

    @ElementCollection
    @CollectionTable(name = "telefonoUsuario", joinColumns = @JoinColumn(name = "usuarioId"))
    @Column(name = "telefono")
    private Set<String> telefonos;                       //Lo pongo como string porque igualmente no lo uso para calcular nada.

    @Column
    private String foto;                                //Es la ruta a la foto.

    public Usuario(){
        this.emails = new LinkedHashSet<>();         //Las colecciones TIENEN que estar inicializadas en el constructor o en su definicion.
        this.telefonos = new LinkedHashSet<>();
    }

    public void agregarTelefono(String nuevoTelefono){
        telefonos.add(nuevoTelefono);
    }

    public void agregarEmail(String nuevoEmail){
        telefonos.add(nuevoEmail);
    }
}
