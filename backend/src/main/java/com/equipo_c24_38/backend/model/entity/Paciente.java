package com.equipo_c24_38.backend.model.entity;

import com.equipo_c24_38.backend.model.dto.DatosRegistroPaciente;
import com.equipo_c24_38.backend.model.dto.EstadoCivil;
import com.equipo_c24_38.backend.model.dto.Genero;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String nombre;
    private int telefono;
    private String capital;
    private String pais;
    private String direccion;
    private int edad;
    private String tipoDeSangre;
    private String idioma;
    //private String documento;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private int hijos;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente, Usuario usuario) {
        this.usuario = usuario;
        this.genero = datosRegistroPaciente.genero().getGenero(); 
        this.nombre = datosRegistroPaciente.nombre();  
        this.telefono = datosRegistroPaciente.telefono();  
        this.capital = datosRegistroPaciente.capital();  
        this.pais = datosRegistroPaciente.pais();  
        this.direccion = datosRegistroPaciente.direccion();  
        this.edad = datosRegistroPaciente.edad();  
        this.tipoDeSangre = datosRegistroPaciente.tipoDeSangre();  
        this.idioma = datosRegistroPaciente.idioma();  
        //this.documento = datosRegistroPaciente.documento();
        this.estadoCivil = datosRegistroPaciente.estadoCivil().getEstadoCivil();  
        this.hijos = datosRegistroPaciente.hijos();  
    }

}
