package com.equipo_c24_38.backend.model.entity;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.tiposDatos.EstadoCivil;
import com.equipo_c24_38.backend.model.tiposDatos.Genero;
import com.equipo_c24_38.backend.model.tiposDatos.Idioma;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String nombre;
    private Long telefono;
    private String capital;
    private String pais;
    private String direccion;
    private int edad;
    private String tipoDeSangre;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private int hijos;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente, Usuario usuario) {
        this.usuario = usuario;
        this.genero = datosRegistroPaciente.genero();
        this.nombre = datosRegistroPaciente.nombre();  
        this.telefono = datosRegistroPaciente.telefono();  
        this.capital = datosRegistroPaciente.capital();  
        this.pais = datosRegistroPaciente.pais();  
        this.direccion = datosRegistroPaciente.direccion();  
        this.edad = datosRegistroPaciente.edad();  
        this.tipoDeSangre = datosRegistroPaciente.tipoDeSangre();  
        this.idioma = datosRegistroPaciente.idioma();
        this.estadoCivil = datosRegistroPaciente.estadoCivil();
        this.hijos = datosRegistroPaciente.hijos();  
    }

}
