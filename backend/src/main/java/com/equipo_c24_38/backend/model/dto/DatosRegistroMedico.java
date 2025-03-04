package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.tiposDatos.Especialidad;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroMedico(
    @NotBlank(message = "{Nombre es obligatorio}")
    String nombre,
    @NotBlank(message = "{edad es obligatorio}")
    Integer edad,
    @NotNull(message = "{Genero es obligatorio}")
    Genero genero,
    @NotBlank(message = "{edad es obligatorio}")
    Long telefono,
    @NotNull
    @NotNull(message = "{Especialidad es obligatorio}")
    Especialidad especialidad,
    @NotNull(message = "{Datos de dirección son obligatorios}")
    String direccion

) {
}
