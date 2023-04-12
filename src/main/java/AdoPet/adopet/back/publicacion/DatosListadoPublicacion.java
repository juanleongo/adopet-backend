package AdoPet.adopet.back.publicacion;

public record DatosListadoPublicacion(Long idpublicaciones, String nombre , String aptitud, String edad, String especie, String genero) {

    public DatosListadoPublicacion(Publicacion publicacion){
        this(publicacion.getIdpublicaciones(), publicacion.getNombreMascota(), publicacion.getEdad(), publicacion.getEspecie(), publicacion.getGenero(), publicacion.getAptitud().toString() );
    }

}
