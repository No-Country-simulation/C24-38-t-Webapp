package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(
        @NotBlank(message = "{Nombre es obligatorio}")
        String nombre,
        @NotNull(message = "{Genero es obligatorio}")
        Paciente genero,
        @NotNull(message = "{Telefono es obligatorio}")
        int telefono,
        @NotBlank(message = "{Ubigeo capital es obligatoria}")
        String capital,
        @NotBlank(message = "{Pais es obligatorio}")
        String pais,
        @NotBlank(message = "{Direccion es obligatoria}")
        String direccion,
        @NotNull(message = "{edad es obligatorio}")
        int edad,
        @NotBlank(message = "{Tipo de sangre es obligatorio}")
        String tipoDeSangre,
        @NotBlank(message = "{Idiomas es necesario}")
        String idioma,
        //@NotBlank(message = "{Descripcion o historia}")
        //String documento,
        @NotNull(message = "{Estado civil es obligatorio}")
        Paciente estadoCivil,
        @NotNull(message = "{Numero de hijos es obligatorio}")
        int hijos
) {
}

