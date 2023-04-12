package AdoPet.adopet.back.perfil;

public record DatosListadoPerfil( Long idperfil, String nombre, String correo, String telefono, String ciudad, String fecha_de_nacimiento, String intereses_mascotas) {
    public DatosListadoPerfil(Perfil perfil){
        this(perfil.getIdperfil(), perfil.getNombre(), perfil.getCorreo(), perfil.getTelefono(), perfil.getCiudad(), perfil.getFecha_de_nacimiento(), perfil.getIntereses_mascotas() );
    }
}
