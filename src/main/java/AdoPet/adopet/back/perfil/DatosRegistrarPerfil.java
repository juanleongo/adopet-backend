package AdoPet.adopet.back.perfil;


import jakarta.validation.constraints.NotBlank;


public record DatosRegistrarPerfil(@NotBlank
                                   String nombre,

                                   @NotBlank
                                   String correo,
                                   @NotBlank
                                   String telefono,
                                   @NotBlank
                                   String ciudad,
                                   String fecha_de_nacimiento,
                                   String intereses_mascotas,
                                   String contrasena

) {
}
