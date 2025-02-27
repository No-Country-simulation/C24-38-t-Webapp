package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.HistorialClinicoDTO;
import com.equipo_c24_38.backend.service.HistorialClinicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/historiales")
@RequiredArgsConstructor
public class HistorialClinicoController {

    private final HistorialClinicoService historialClinicoService;

    @GetMapping
    public ResponseEntity<List<HistorialClinicoDTO>> obtenerTodos() {
        return ResponseEntity.ok(historialClinicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinicoDTO> obtenerPorId(@PathVariable Long id) {
        Optional<HistorialClinicoDTO> historial = historialClinicoService.obtenerPorId(id);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialClinicoDTO> guardar(@Valid @RequestBody HistorialClinicoDTO dto) {
        return ResponseEntity.ok(historialClinicoService.guardar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historialClinicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}