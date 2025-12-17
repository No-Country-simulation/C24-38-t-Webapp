package com.equipo_c24_38.backend.repository;

import com.equipo_c24_38.backend.model.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    @Query("SELECT m.nombre FROM Medico m")
    List<String> findAllNombres();

}
