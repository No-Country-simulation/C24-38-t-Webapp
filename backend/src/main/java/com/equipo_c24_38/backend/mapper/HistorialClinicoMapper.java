package com.equipo_c24_38.backend.mapper;

import com.equipo_c24_38.backend.model.dto.HistorialClinicoDTO;
import com.equipo_c24_38.backend.model.entity.HistorialClinico;
import org.springframework.stereotype.Component;

@Component
public class HistorialClinicoMapper {

    public HistorialClinicoDTO toDTO(HistorialClinico historial) {
        HistorialClinicoDTO dto = new HistorialClinicoDTO();
        dto.setId(historial.getIdHistorialClinico());
        dto.setPacienteId(historial.getPaciente().getId());
        dto.setFechaDiagnostico(historial.getFechaDiagnostico());
        dto.setDiagnostico(historial.getDiagnostico());
        dto.setTratamiento(historial.getTratamiento());
        return dto;
    }

    public HistorialClinico toEntity(HistorialClinicoDTO dto) {
        HistorialClinico historial = new HistorialClinico();
        historial.setIdHistorialClinico(dto.getId());
        historial.setFechaDiagnostico(dto.getFechaDiagnostico());
        historial.setDiagnostico(dto.getDiagnostico());
        historial.setTratamiento(dto.getTratamiento());
        return historial;
    }
}