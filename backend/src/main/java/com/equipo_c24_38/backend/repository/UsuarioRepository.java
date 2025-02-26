package com.equipo_c24_38.backend.repository;

import com.equipo_c24_38.backend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.contrasena = :contrasena")
    Optional<Usuario> buscarUsuarioPorEmailYContrasena(String email, String contrasena);

}
