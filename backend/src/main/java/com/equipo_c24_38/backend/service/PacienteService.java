package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.repository.PacienteRepository;
import com.equipo_c24_38.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Paciente RegistrarPaciente(DatosRegistroPaciente datosRegistroPaciente, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Paciente paciente = new Paciente(datosRegistroPaciente, usuario);
        return pacienteRepository.save(paciente);
    }
}
