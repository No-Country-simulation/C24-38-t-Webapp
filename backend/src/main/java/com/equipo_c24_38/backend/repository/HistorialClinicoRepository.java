package com.equipo_c24_38.backend.repository;

import com.equipo_c24_38.backend.model.entity.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long> {

    // Buscar historiales por ID de paciente
    List<HistorialClinico> findByPacienteId(Long pacienteId);

    // Buscar historiales por ID de médico
    List<HistorialClinico> findByMedicoId(Long medicoId);
}
