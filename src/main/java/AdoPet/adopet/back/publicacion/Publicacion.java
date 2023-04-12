package AdoPet.adopet.back.publicacion;

import AdoPet.adopet.back.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

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
    private String fechaPublicacion;
    private boolean activo;
    private boolean favoritos;
    private  String estado;

    private String imagen;





    public Publicacion(DatosRegistroPublicacion datosRegistroPublicacion) {
        this.activo = true;
        this.favoritos = false;
        this.nombreMascota = datosRegistroPublicacion.nombreMascota();
        this.edad = datosRegistroPublicacion.edad();
        this.genero = datosRegistroPublicacion.genero();
        this.especie = datosRegistroPublicacion.especie();
        this.aptitud = datosRegistroPublicacion.aptitud();
        this.ubicacion = datosRegistroPublicacion.ubicacion();
        this.descripcion=datosRegistroPublicacion.descripcion();
        this.estado =datosRegistroPublicacion.estado();
        this.fechaPublicacion=datosRegistroPublicacion.fechaPublicacion();
        this.imagen=datosRegistroPublicacion.imagen();

    }

    public void actualizarDatos(DatosActualizarPublicacion datosActualizarPublicacion) {
       // if(datosActualizarPublicacion.nombre() != null){
         //   this.nombreMascota=datosActualizarPublicacion.nombre();
        //}
        if(datosActualizarPublicacion.imagen() != null){
            this.imagen=datosActualizarPublicacion.imagen();
        }
    }

    public void desactivarPublicacion() {
        this.activo=false;
    }

    public void nuevoFavorito() {
        this.favoritos=true;
    }

    public void actualizarEstado(DatosActualizarEstado datosActualizarEstado) {
        this.estado=datosActualizarEstado.estado();
    }

    public void desactivarFavorito() {
        this.favoritos=false;
    }
}
