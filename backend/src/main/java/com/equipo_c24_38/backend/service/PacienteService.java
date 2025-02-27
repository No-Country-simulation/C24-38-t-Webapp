package com.equipo_c24_38.backend.service;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.entity.Paciente;
import com.equipo_c24_38.backend.model.entity.Usuario;
import com.equipo_c24_38.backend.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioService usuarioService;

    public PacienteService(PacienteRepository pacienteRepository, UsuarioService usuarioService) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioService = usuarioService;
    }

    public Paciente agregar(DatosRegistroPaciente datosRegistroPaciente) {
        Usuario usuario = new Usuario(
                datosRegistroPaciente.documento(),
                datosRegistroPaciente.email(),
                datosRegistroPaciente.contrasena()
        );
        usuarioService.agregar(usuario);

        Paciente paciente = new Paciente(
                usuario.getDocumento(),
                usuario.getEmail(),
                usuario.getContrasena(),
                datosRegistroPaciente.genero(),
                datosRegistroPaciente.telefono(),
                datosRegistroPaciente.capital(),
                datosRegistroPaciente.pais(),
                datosRegistroPaciente.direccion(),
                datosRegistroPaciente.edad(),
                datosRegistroPaciente.tipoDeSangre(),
                datosRegistroPaciente.idioma(),
                datosRegistroPaciente.estadoCivil(),
                datosRegistroPaciente.hijos()
        );
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPaciente(String email, String contrasena) {
        Optional<Usuario> usuario = usuarioService.buscarUsuario(email, contrasena);
        return usuario.flatMap(u -> pacienteRepository.findByUsuario(u));
    }

}
