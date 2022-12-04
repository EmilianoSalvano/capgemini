package domain.models.entities.productos;

import domain.models.entities.EntidadPersistente;
import domain.models.entities.tiendas.TiendaVendedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductoPersonalizado")
@Getter
@Setter
public class ProductoPersonalizado extends EntidadPersistente {
    @OneToMany(mappedBy = "productoPersonalizado", cascade = {CascadeType.PERSIST, CascadeType.MERGE})  //"En la clase personalizaciones buscame como productoPersonalizado"
    private List<Personalizacion> personalizaciones;

    @ManyToOne
    @JoinColumn(name = "productoBase", referencedColumnName = "id")
    private ProductoBase productoBase;

    @ManyToOne
    @JoinColumn(name = "idTienda", referencedColumnName = "id")
    private TiendaVendedor tienda;

    @ElementCollection
    @CollectionTable(name = "fotoProductoBase", joinColumns = @JoinColumn(name = "idProductobase"))
    @Column(name = "ruta")
    private List<String> fotos;

    public ProductoPersonalizado(){
        personalizaciones = new ArrayList<Personalizacion>();
        fotos = new ArrayList<String>();
    }

    public void agregarPersonalizacion(Personalizacion nuevaPersonalizacion){
        this.personalizaciones.add(nuevaPersonalizacion);
        nuevaPersonalizacion.setProductoPersonalizado(this);
        //Como la relacion que hice es BIDIRECCIONAL, tengo que decirle a la personalizacion
        //que apunte a este producto personalizado.
    }

    public void agregarFoto(String nuevaFoto){
        fotos.add(nuevaFoto);
    }
}
