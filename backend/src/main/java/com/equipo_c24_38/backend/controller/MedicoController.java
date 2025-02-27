package com.equipo_c24_38.backend.controller;

import com.equipo_c24_38.backend.model.dto.DatosRegistroMedico;
import com.equipo_c24_38.backend.model.dto.DatosRespuestaMedico;
import com.equipo_c24_38.backend.model.entity.Medico;
import com.equipo_c24_38.backend.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

  @Autowired
  private MedicoService medicoService;

  @PostMapping("/registrar")
  public ResponseEntity<?> registrarMedico(
      @RequestBody DatosRegistroMedico datosRegistroMedico,
      @RequestParam Long idUsuario) {
    Medico medico = medicoService.registrarMedico(datosRegistroMedico, idUsuario);
    DatosRespuestaMedico datosRespuestaMedico=new DatosRespuestaMedico(medico);
    return ResponseEntity.ok(datosRespuestaMedico);
  }

}
