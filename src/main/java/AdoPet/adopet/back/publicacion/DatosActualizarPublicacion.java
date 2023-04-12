package AdoPet.adopet.back.publicacion;

import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Array;

public record DatosActualizarPublicacion(@NotNull Long idpublicaciones, String imagen) {
}
