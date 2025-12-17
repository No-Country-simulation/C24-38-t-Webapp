package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Medico;
import com.equipo_c24_38.backend.model.tiposDatos.Especialidad;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;

public record DatosRespuestaMedico(
    String nombre,
    Integer edad,
    Genero genero,
    Long telefono,
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
