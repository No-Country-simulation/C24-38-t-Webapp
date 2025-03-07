package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.tiposDatos.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record DatosRegistrarUsuario(

        @NotBlank
        String documento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contrasena,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDateTime fechaRegistro

    ) {
}
