package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.mapper.HistorialClinicoMapper;
import com.equipo_c24_38.backend.model.dto.HistorialClinicoDTO;
import com.equipo_c24_38.backend.model.entity.HistorialClinico;
import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.repository.HistorialClinicoRepository;
import com.equipo_c24_38.backend.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistorialClinicoService {

    private final HistorialClinicoRepository historialClinicoRepository;
    private final PacienteRepository pacienteRepository;
    private final HistorialClinicoMapper historialClinicoMapper;

    // Obtener todos los historiales
    public List<HistorialClinicoDTO> obtenerTodos() {
        return historialClinicoRepository.findAll()
                .stream()
                .map(historialClinicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un historial por ID
    public Optional<HistorialClinicoDTO> obtenerPorId(Long id) {
        return historialClinicoRepository.findById(id).map(historialClinicoMapper::toDTO);
    }

    // Guardar un historial clínico
    public HistorialClinicoDTO guardar(HistorialClinicoDTO dto) {
        HistorialClinico historial = historialClinicoMapper.toEntity(dto);

        // Asignar paciente y médico
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        historial.setPaciente(paciente);

        historial = historialClinicoRepository.save(historial);
        return historialClinicoMapper.toDTO(historial);
    }

    // Eliminar un historial
    public void eliminar(Long id) {
        historialClinicoRepository.deleteById(id);
    }
}
