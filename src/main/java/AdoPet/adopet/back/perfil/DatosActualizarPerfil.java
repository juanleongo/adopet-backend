package AdoPet.adopet.back.perfil;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPerfil(@NotNull Long idperfil, String telefono, String interesesMascotas) {
}
