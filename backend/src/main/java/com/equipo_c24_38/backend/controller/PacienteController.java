package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaPaciente;
import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.repository.PacienteRepository;
import com.equipo_c24_38.backend.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPaciente(
            @RequestBody DatosRegistroPaciente datosRegistroPaciente,
            @RequestParam Long idUsuario){
        Paciente paciente = pacienteService.RegistrarPaciente(datosRegistroPaciente, idUsuario);
        DatosRespuestaPaciente datosRespuestaPaciente = new DatosRespuestaPaciente(paciente);
        return ResponseEntity.ok("Paciente registrado");
    }
}
