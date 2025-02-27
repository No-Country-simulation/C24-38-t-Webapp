package com.equipo_c24_38.backend.model.dto;

import com.equipo_c24_38.backend.model.entity.Paciente;
import java.time.LocalDateTime;

public record DatosRespuestaPaciente(
        Long id,
        String documento,
        String email,
        String contrasena,
        LocalDateTime fechaRegistro,
        Paciente.Genero genero,
        int telefono,
        String capital,
        String pais,
        String direccion,
        int edad,
        String tipoDeSangre,
        String idioma,
        Paciente.EstadoCivil estadoCivil,
        int hijos
) {
    public DatosRespuestaPaciente(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getDocumento(),
                paciente.getEmail(),
                paciente.getContrasena(),
                paciente.getFechaRegistro(),
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
