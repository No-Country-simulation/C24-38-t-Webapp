package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.DatosRegistroMedico;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaMedico;
import com.equipo_c24_38.backend.model.entity.Medico;
import com.equipo_c24_38.backend.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/medicos", method = {RequestMethod.POST, RequestMethod.GET})
@Tag(name = "Controlador médicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Operation(summary = "Registra a un médico, incluso detecta si el usuario se registró como médico")
    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity<?> registrarMedico(
        @RequestBody DatosRegistroMedico datosRegistroMedico,
        @RequestParam Long idUsuario) {
      Medico medico = medicoService.registrarMedico(datosRegistroMedico, idUsuario);
      DatosRespuestaMedico datosRespuestaMedico=new DatosRespuestaMedico(medico);
      return ResponseEntity.ok(datosRespuestaMedico);
    }

    @Operation(summary = "Muestra solo los nombres de los médicos")
    @GetMapping("/listarPorNombre")
    public ResponseEntity<List<String>> listarMedicos() {
        List<String> nombresMedicos = medicoService.listarMedicoPorNombre();

        if (nombresMedicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(nombresMedicos);
        }
    }

}
