package AdoPet.adopet.back.publicacion;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPublicacion(@NotNull Long idpublicaciones,String nombre, String ubicacion) {
}
