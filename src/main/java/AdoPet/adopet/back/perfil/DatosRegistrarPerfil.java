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
                                   String fechaDeNacimiento,
                                   String interesesMascotas,
                                   String contrasena

) {
}
