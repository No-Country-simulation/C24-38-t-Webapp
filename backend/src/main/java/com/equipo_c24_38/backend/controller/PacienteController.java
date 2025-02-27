package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaPaciente;
import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<DatosRespuestaPaciente> registrar(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente) {
        Paciente paciente = pacienteService.agregar(datosRegistroPaciente);
        DatosRespuestaPaciente datosRespuestaPaciente = new DatosRespuestaPaciente(paciente);
        return ResponseEntity.ok().body(datosRespuestaPaciente);
    }

    @PostMapping("/iniciarSesion")
    @Transactional
    public String iniciarSesion(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(paciente.getEmail(), paciente.getContrasena());
        if (pacienteBuscado.isEmpty()) {
            return "Paciente no encontrado";
        } else {
            return "Paciente inició sesión";
        }
    }

}
