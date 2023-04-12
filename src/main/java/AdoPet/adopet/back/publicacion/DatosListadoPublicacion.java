package AdoPet.adopet.back.publicacion;

public record DatosListadoPublicacion(Long idpublicaciones, String nombre ,String edad, String genero,String especie, String ubicacion,String descripcion, String aptitud,String fechaPublicacion,String estado,String imagen ) {

    public DatosListadoPublicacion(Publicacion publicacion){
        this(publicacion.getIdpublicaciones(), publicacion.getNombreMascota(), publicacion.getEdad(),publicacion.getGenero(), publicacion.getEspecie(),publicacion.getUbicacion() ,publicacion.getDescripcion(), publicacion.getAptitud().toString(), publicacion.getFechaPublicacion(),publicacion.getEstado() , publicacion.getImagen());
    }

}
