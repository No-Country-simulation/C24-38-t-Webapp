package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.model.dto.DatosRegistroMedico;
import com.equipo_c24_38.backend.model.entity.Medico;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.repository.MedicoRepository;
import com.equipo_c24_38.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicoService {

  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  public Medico registrarMedico(DatosRegistroMedico datosRegistroMedico, Long idUsuario) {
    Usuario usuario = usuarioRepository.findById(idUsuario)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    Medico medico = new Medico(datosRegistroMedico, usuario);

    return medicoRepository.save(medico);
  }
}
