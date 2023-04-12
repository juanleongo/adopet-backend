package AdoPet.adopet.back.publicacion;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarEstado(@NotNull Long idpublicaciones, String estado) {
}
