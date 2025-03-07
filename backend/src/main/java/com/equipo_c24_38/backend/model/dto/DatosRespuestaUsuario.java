package com.equipo_c24_38.backend.model.dto;


import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.model.tiposDatos.TipoUsuario;

import java.time.LocalDateTime;

public record DatosRespuestaUsuario(

        Long id,
        String documento,
        String email,
        String contrasena,
        LocalDateTime fechaRegistro

    ) {

    public DatosRespuestaUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getDocumento(), usuario.getEmail(),
                usuario.getContrasena(), usuario.getFechaRegistro());
    }

}
