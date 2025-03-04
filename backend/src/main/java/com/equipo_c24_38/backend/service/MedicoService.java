package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.infra.errores.TipoUsuarioInvalidoException;
import com.equipo_c24_38.backend.model.dto.DatosRegistroMedico;
import com.equipo_c24_38.backend.model.entity.Medico;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.model.tiposDatos.TipoUsuario;
import com.equipo_c24_38.backend.repository.MedicoRepository;
import com.equipo_c24_38.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  public Medico registrarMedico(DatosRegistroMedico datosRegistroMedico, Long idUsuario) {
    Usuario usuario = usuarioRepository.findById(idUsuario)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (usuario.getTipoUsuario() == TipoUsuario.MEDICO) {
      Medico medico = new Medico(datosRegistroMedico, usuario);

      return medicoRepository.save(medico);
    } else {
      throw new TipoUsuarioInvalidoException("El usuario no es de tipo MEDICO");
    }

  }
}
