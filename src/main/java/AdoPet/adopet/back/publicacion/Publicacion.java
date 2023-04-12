package AdoPet.adopet.back.publicacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "publicaciones")
@Entity(name = "Publicacion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idpublicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpublicaciones;
    private String nombreMascota;
    private String edad;
    private String genero;
    private String especie;
    private String ubicacion;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Aptitud aptitud;
    private boolean activo;


    public Publicacion(DatosRegistroPublicacion datosRegistroPublicacion) {
        this.activo = true;
        this.nombreMascota = datosRegistroPublicacion.nombreMascota();
        this.edad = datosRegistroPublicacion.edad();
        this.genero = datosRegistroPublicacion.genero();
        this.especie = datosRegistroPublicacion.especie();
        this.aptitud = datosRegistroPublicacion.aptitud();
        this.ubicacion = datosRegistroPublicacion.ubicacion();
        this.descripcion=datosRegistroPublicacion.descripcion();
    }

    public void actualizarDatos(DatosActualizarPublicacion datosActualizarPublicacion) {
        if(datosActualizarPublicacion.nombre() != null){
            this.nombreMascota=datosActualizarPublicacion.nombre();
        }
        if(datosActualizarPublicacion.ubicacion() != null){
            this.ubicacion=datosActualizarPublicacion.ubicacion();
        }
    }

    public void desactivarPublicacion() {
        this.activo=false;
    }
}
