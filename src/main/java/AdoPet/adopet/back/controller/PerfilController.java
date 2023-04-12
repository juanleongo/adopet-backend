package AdoPet.adopet.back.controller;

import AdoPet.adopet.back.perfil.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping("/registrar")
    public void registrarPerfil(@RequestBody @Valid DatosRegistrarPerfil datosRegistrarPerfil){
        perfilRepository.save(new Perfil(datosRegistrarPerfil));
    }

    @GetMapping("/listar")
    public List<DatosListadoPerfil> listarPerfil(){
        return perfilRepository.findAll().stream().map(DatosListadoPerfil::new).toList();
    }
    @PutMapping("/actualizar")
    @Transactional
    public void actualizarPerfil(@RequestBody DatosActualizarPerfil datosActualizarPerfil){
        Perfil perfil = perfilRepository.getReferenceById(datosActualizarPerfil.idperfil());
        perfil.actualizarDatos(datosActualizarPerfil);
    }

    @DeleteMapping("/borrar")
    @Transactional
    public void eliminarPerfil(@PathVariable Long idperfil){
        Perfil perfil = perfilRepository.getReferenceById(idperfil);
        perfil.desactivarPerfil();
    }
}



