package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.model.dto.DatosRegistrarUsuario;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaUsuario;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario agregar(DatosRegistrarUsuario datosRegistrarUsuario) {
        Usuario usuario = new Usuario(datosRegistrarUsuario.documento(),
                datosRegistrarUsuario.email(), datosRegistrarUsuario.contrasena());
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUsuario(String email, String contrasena) {
        return usuarioRepository.buscarUsuarioPorEmailYContrasena(email, contrasena);
    }

}
