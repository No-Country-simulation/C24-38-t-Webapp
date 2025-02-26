package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Medico;

public record DatosRespuestaMedico(
    String nombre,
    Integer edad,
    Genero genero,
    Integer telefono,
    Especialidad especialidad,
    String direccion
) {
  public DatosRespuestaMedico(Medico medico) {
    this(
        medico.getNombre(),
        medico.getEdad(),
        medico.getGenero(),
        medico.getTelefono(),
        medico.getEspecialidad(),
        medico.getDireccion()
    );
  }
}
