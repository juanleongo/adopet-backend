package AdoPet.adopet.back.perfil;

public record DatosListadoPerfil( Long idperfil, String nombre, String correo, String telefono, String ciudad, String fechaDeNacimiento, String interesesMascotas) {
    public DatosListadoPerfil(Perfil perfil){
        this(perfil.getIdperfil(), perfil.getNombre(), perfil.getCorreo(), perfil.getTelefono(), perfil.getCiudad(), perfil.getFechaDeNacimiento(), perfil.getInteresesMascotas() );
    }
}
