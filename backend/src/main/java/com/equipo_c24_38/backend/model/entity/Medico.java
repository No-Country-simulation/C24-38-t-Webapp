package com.equipo_c24_38.backend.model.entity;

import com.equipo_c24_38.backend.model.dto.DatosRegistroMedico;
import com.equipo_c24_38.backend.model.tiposDatos.Especialidad;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Medico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "id_usuario", referencedColumnName = "id")
  private Usuario usuario;

  private String nombre;

  private int edad;

  @Enumerated(EnumType.STRING)
  private Genero genero;

  private Long telefono;

  @Enumerated(EnumType.STRING)
  private Especialidad especialidad;

  private String direccion;

  public Medico(DatosRegistroMedico datosRegistroMedico, Usuario usuario) {
    this.usuario = usuario;
    this.nombre = datosRegistroMedico.nombre();
    this.edad = datosRegistroMedico.edad();
    this.genero = datosRegistroMedico.genero();
    this.telefono = datosRegistroMedico.telefono();
    this.especialidad = datosRegistroMedico.especialidad();
    this.direccion = datosRegistroMedico.direccion();
  }
}


