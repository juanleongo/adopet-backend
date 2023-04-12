package AdoPet.adopet.back.perfil;

import AdoPet.adopet.back.publicacion.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    @Query(value="select * from perfil order by idperfil desc limit 1;", nativeQuery=true)
    List<Perfil> findByLastPublicacion();
}
