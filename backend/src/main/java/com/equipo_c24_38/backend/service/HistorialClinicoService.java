package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.model.entity.HistorialClinico;
import com.equipo_c24_38.backend.repository.HistorialClinicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistorialClinicoService {

    private final HistorialClinicoRepository historialClinicoRepository;

    // Obtener todos los historiales clínicos
    public List<HistorialClinico> obtenerTodos() {
        return historialClinicoRepository.findAll();
    }

    // Obtener un historial por ID
    public Optional<HistorialClinico> obtenerPorId(Long id) {
        return historialClinicoRepository.findById(id);
    }

    // Obtener historiales por paciente
    public List<HistorialClinico> obtenerPorPaciente(Long pacienteId) {
        return historialClinicoRepository.findByPacienteId(pacienteId);
    }

    // Obtener historiales por médico
    public List<HistorialClinico> obtenerPorMedico(Long medicoId) {
        return historialClinicoRepository.findByMedicoId(medicoId);
    }

    // Guardar un historial clínico
    public HistorialClinico guardar(HistorialClinico historialClinico) {
        return historialClinicoRepository.save(historialClinico);
    }

    // Eliminar un historial clínico por ID
    public void eliminar(Long id) {
        historialClinicoRepository.deleteById(id);
    }
}