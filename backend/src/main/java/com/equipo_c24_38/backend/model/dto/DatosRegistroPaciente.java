package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(
        @NotBlank
        String documento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contrasena,
        @NotNull
        Paciente.Genero genero,
        @NotNull
        int telefono,
        @NotBlank
        String capital,
        @NotBlank
        String pais,
        @NotBlank
        String direccion,
        @NotNull
        int edad,
        @NotBlank
        String tipoDeSangre,
        @NotBlank
        String idioma,
        @NotNull
        Paciente.EstadoCivil estadoCivil,
        @NotNull
        int hijos
) {
}

