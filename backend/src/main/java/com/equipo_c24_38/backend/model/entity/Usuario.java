package com.equipo_c24_38.backend.model.entity;

import com.equipo_c24_38.backend.model.dto.DatosRegistrarUsuario;
import com.equipo_c24_38.backend.model.tiposDatos.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
    @Column(name = "tipo_usuario")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    public Usuario(String documento, String email, String contrasena, TipoUsuario tipoUsario) {
        this.documento = documento;
        this.email = email;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsario;
    }

    public Usuario(DatosRegistrarUsuario datosRegistrarUsuario) {
        this.documento = datosRegistrarUsuario.documento();
        this.email = datosRegistrarUsuario.email();
        this.contrasena = datosRegistrarUsuario.contrasena();
        this.tipoUsuario = datosRegistrarUsuario.tipoUsuario();
    }

}
