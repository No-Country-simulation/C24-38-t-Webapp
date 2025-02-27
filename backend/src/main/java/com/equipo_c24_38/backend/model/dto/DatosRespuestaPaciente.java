package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import java.time.LocalDateTime;

public record DatosRespuestaPaciente(
        String nombre,
        Genero genero,
        int telefono,
        String capital,
        String pais,
        String direccion,
        int edad,
        String tipoDeSangre,
        String idioma,
        //String documento,
        EstadoCivil estadoCivil,
        int hijos
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
                //paciente.getDocumento(),
                paciente.getEstadoCivil(),
                paciente.getHijos()
        );
    }
}
