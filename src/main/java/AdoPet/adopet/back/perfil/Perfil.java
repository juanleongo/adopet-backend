package AdoPet.adopet.back.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
    @Table(name = "perfil")
    @Entity(name = "Perfil")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "idperfil")

    public class Perfil {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long idperfil;
        private String nombre;
        private String correo;
        private String telefono;
        private String ciudad;
        private String fecha_de_nacimiento;
        private String intereses_mascotas;
        private String contrasena;
        private boolean activo;

        public Perfil(DatosRegistrarPerfil datosRegistrarPerfil) {
            this.activo = true;
            this.nombre = datosRegistrarPerfil.nombre();
            this.correo = datosRegistrarPerfil.correo();
            this.telefono = datosRegistrarPerfil.telefono();
            this.ciudad = datosRegistrarPerfil.ciudad();
            this.fecha_de_nacimiento = datosRegistrarPerfil.fecha_de_nacimiento();
            this.intereses_mascotas = datosRegistrarPerfil.intereses_mascotas();
            this.contrasena = datosRegistrarPerfil.contrasena();
        }

        public void actualizarDatos(DatosActualizarPerfil datosActualizarPerfil) {
            if(datosActualizarPerfil.telefono() != null){
                this.telefono=datosActualizarPerfil.telefono();
            }
            if(datosActualizarPerfil.intereses_mascotas() != null){
                this.intereses_mascotas=datosActualizarPerfil.intereses_mascotas();
            }
        }

        public void desactivarPerfil() {
            this.activo=false;
        }

}
