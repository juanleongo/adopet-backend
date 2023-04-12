package AdoPet.adopet.back.publicacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion,Long> {
    List<Publicacion> findByActivoTrue();

    List<Publicacion>findByFavoritosTrue();
}
