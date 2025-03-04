package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.model.tiposDatos.EstadoCivil;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;
import com.equipo_c24_38.backend.model.tiposDatos.Idioma;

public record DatosRespuestaPaciente(
        String nombre,
        Genero genero,
        Long telefono,
        String capital,
        String pais,
        String direccion,
        Integer edad,
        String tipoDeSangre,
        Idioma idioma,
        EstadoCivil estadoCivil,
        Integer hijos
) {
    public DatosRespuestaPaciente(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getGenero(),
                paciente.getTelefono(),
                paciente.getCapital(),
                paciente.getPais(),
                paciente.getDireccion(),
                paciente.getEdad(),
                paciente.getTipoDeSangre(),
                paciente.getIdioma(),
                paciente.getEstadoCivil(),
                paciente.getHijos()
        );
    }
}
