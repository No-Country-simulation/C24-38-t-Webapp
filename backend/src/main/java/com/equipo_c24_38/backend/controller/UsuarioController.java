package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.DatosRegistrarUsuario;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaUsuario;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1", method = RequestMethod.POST)
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> registrar(@RequestBody @Valid DatosRegistrarUsuario datosRegistrarUsuario) {
        Usuario usuario = usuarioService.agregar(datosRegistrarUsuario);
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(datosRespuestaUsuario);
    }

    @PostMapping("/iniciarSesion")
    @Transactional
    public String iniciarSesion(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioBuscado = usuarioService.buscarUsuario(usuario.getEmail(), usuario.getContrasena());
        if (usuarioBuscado.isEmpty()) {
            return "Usuario no encontrado";
        } else {
            return "Usuario inició sesión";
        }
    }

}
