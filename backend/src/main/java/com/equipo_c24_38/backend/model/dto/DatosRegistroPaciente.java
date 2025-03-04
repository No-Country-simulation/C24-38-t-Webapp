package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.model.tiposDatos.EstadoCivil;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;
import com.equipo_c24_38.backend.model.tiposDatos.Idioma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(
        @NotBlank(message = "{Nombre es obligatorio}")
        String nombre,
        @NotNull(message = "{Genero es obligatorio}")
        Genero genero,
        @NotNull(message = "{Telefono es obligatorio}")
        Long telefono,
        @NotBlank(message = "{Ubigeo capital es obligatoria}")
        String capital,
        @NotBlank(message = "{Pais es obligatorio}")
        String pais,
        @NotBlank(message = "{Direccion es obligatoria}")
        String direccion,
        @NotNull(message = "{edad es obligatorio}")
        Integer edad,
        @NotBlank(message = "{Tipo de sangre es obligatorio}")
        String tipoDeSangre,
        @NotBlank(message = "{Idiomas es necesario}")
        Idioma idioma,
        @NotNull(message = "{Estado civil es obligatorio}")
        EstadoCivil estadoCivil,
        @NotNull(message = "{Numero de hijos es obligatorio}")
        Integer hijos
) {
}

