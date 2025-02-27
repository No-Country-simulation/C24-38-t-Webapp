package com.equipo_c24_38.backend.repository;

import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
