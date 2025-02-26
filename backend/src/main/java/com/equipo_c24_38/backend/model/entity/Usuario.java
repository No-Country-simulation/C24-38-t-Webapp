package com.equipo_c24_38.backend.model.entity;

import com.equipo_c24_38.backend.model.dto.DatosRegistrarUsuario;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "documento", unique = true, length = 10)
    private String documento;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "contrasena")
    private String contrasena;
    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    public Usuario() {
    }

    public Usuario(String documento, String email, String contrasena) {
        this.documento = documento;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Usuario(DatosRegistrarUsuario datosRegistrarUsuario) {
        this.documento = datosRegistrarUsuario.documento();
        this.email = datosRegistrarUsuario.email();
        this.contrasena = datosRegistrarUsuario.contrasena();
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

}
