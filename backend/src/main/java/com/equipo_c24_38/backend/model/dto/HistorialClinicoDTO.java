package com.equipo_c24_38.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistorialClinicoDTO {

    private Long id;

    @NotNull(message = "El ID del paciente es obligatorio")
    private Long pacienteId;

    @NotNull(message = "La fecha de diagnóstico es obligatoria")
    private LocalDateTime fechaDiagnostico;

    @NotBlank(message = "El diagnóstico no puede estar vacío")
    private String diagnostico;

    @NotBlank(message = "El tratamiento no puede estar vacío")
    private String tratamiento;
}