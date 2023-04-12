package AdoPet.adopet.back.publicacion;


import AdoPet.adopet.back.perfil.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroPublicacion(@NotBlank
                                   String nombreMascota,

                                       @NotBlank
                                   String edad,
                                       @NotBlank
                                   String genero,
                                       @NotBlank
                                   String especie,
                                       String ubicacion,
                                       String descripcion,

                                       @NotNull
                                   Aptitud aptitud,
                                       String fechaPublicacion,
                                       String estado,
                                       String imagen



                                   ) {
}
