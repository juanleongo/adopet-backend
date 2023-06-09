package AdoPet.adopet.back.controller;


import AdoPet.adopet.back.publicacion.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @PostMapping("/registrar")
    public void registrarPublicacion(@RequestBody @Valid DatosRegistroPublicacion datosRegistroPublicacion){
        publicacionRepository.save(new Publicacion(datosRegistroPublicacion));
    }

    @GetMapping("/listar")
    public List<DatosListadoPublicacion> listarPublicaciones(){
       //return publicacionRepository.findAll().stream().map(DatosListadoPublicacion::new).toList();
        return publicacionRepository.findByActivoTrue().stream().map(DatosListadoPublicacion::new).toList();
    }
    @GetMapping("/listar/favoritos")
    public List<DatosListadoPublicacion> listarPublicacionesFavoritas(){
        //return publicacionRepository.findAll().stream().map(DatosListadoPublicacion::new).toList();
        return publicacionRepository.findByFavoritosTrue().stream().map(DatosListadoPublicacion::new).toList();
    }
    @GetMapping("/ultimo")
    public List<DatosListadoPublicacion> listarUltimaPublicacion(){
        //return publicacionRepository.findAll().stream().map(DatosListadoPublicacion::new).toList();
        return publicacionRepository.findByLastPublicacion().stream().map(DatosListadoPublicacion::new).toList();
    }

    @PutMapping("/actualizar")
    @Transactional
    public void actualizarPublicacion(@RequestBody DatosActualizarPublicacion datosActualizarPublicacion){
        Publicacion publicacion = publicacionRepository.getReferenceById(datosActualizarPublicacion.idpublicaciones());
        publicacion.actualizarDatos(datosActualizarPublicacion);

    }
    @PutMapping("/estado")
    @Transactional
    public void publicacionEstado(@RequestBody DatosActualizarEstado datosActualizarEstado){
        Publicacion publicacion = publicacionRepository.getReferenceById(datosActualizarEstado.idpublicaciones());
        publicacion.actualizarEstado(datosActualizarEstado);
    }
    @PutMapping("/favoritos/{idpublicaciones}")
    @Transactional
    public void publicacionfavoritos(@PathVariable Long idpublicaciones){
        Publicacion publicacion = publicacionRepository.getReferenceById(idpublicaciones);
        publicacion.nuevoFavorito();
    }



    @DeleteMapping("/borrar/{idpublicaciones}")
    @Transactional
    public void eliminarPublicacion(@PathVariable Long idpublicaciones){
        Publicacion publicacion = publicacionRepository.getReferenceById(idpublicaciones);
        publicacion.desactivarPublicacion();
    }

    @DeleteMapping("/favoritos/borrar/{idpublicaciones}")
    @Transactional
    public void eliminarFavorito(@PathVariable Long idpublicaciones){
        Publicacion publicacion = publicacionRepository.getReferenceById(idpublicaciones);
        publicacion.desactivarFavorito();
    }
}
