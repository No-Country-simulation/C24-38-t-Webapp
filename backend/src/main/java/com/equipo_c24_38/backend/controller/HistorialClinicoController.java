package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.HistorialClinicoDTO;
import com.equipo_c24_38.backend.service.HistorialClinicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/historiales")
@RequiredArgsConstructor
@Tag(name = "Controlador historiales clinicos")
public class HistorialClinicoController {

    private final HistorialClinicoService historialClinicoService;

    @Operation(summary = "Muestra todos los historiales clínicos")
    @GetMapping
    public ResponseEntity<List<HistorialClinicoDTO>> obtenerTodos() {
        return ResponseEntity.ok(historialClinicoService.obtenerTodos());
    }

    @Operation(summary = "Muestra un historial clínico en específico")
    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinicoDTO> obtenerPorId(@PathVariable Long id) {
        Optional<HistorialClinicoDTO> historial = historialClinicoService.obtenerPorId(id);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registra un historial clínico. Es necesario incluir el id del paciente y médico")
    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<HistorialClinicoDTO> guardar(@Valid @RequestBody HistorialClinicoDTO dto) {
        return ResponseEntity.ok(historialClinicoService.guardar(dto));
    }

    @Operation(summary = "Elimina un historial clínico en específico")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historialClinicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}