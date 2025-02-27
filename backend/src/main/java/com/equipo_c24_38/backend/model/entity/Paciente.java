package com.equipo_c24_38.backend.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paciente;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private int telefono;
    private String capital;
    private String pais;
    private String direccion;
    private int edad;
    private String tipoDeSangre;
    private String idioma;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private int hijos;

    public enum Genero {
        MASCULINO, FEMENINO, OTRO
    }
    public enum EstadoCivil {
        SOLTERO, CASADO, DIVORCIADO, VIUDO
    }
    // Getters y constructores
    public Paciente() {
        super();
    }

    public Paciente(String documento, String email, String contrasena, Genero genero, int telefono, String capital, String pais, String direccion, int edad, String tipoDeSangre, String idioma, EstadoCivil estadoCivil, int hijos) {
        super(documento, email, contrasena);
        this.genero = genero;
        this.telefono = telefono;
        this.capital = capital;
        this.pais = pais;
        this.direccion = direccion;
        this.edad = edad;
        this.tipoDeSangre = tipoDeSangre;
        this.idioma = idioma;
        this.estadoCivil = estadoCivil;
        this.hijos = hijos;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCapital() {
        return capital;
    }

    public String getPais() {
        return pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public String getIdioma() {
        return idioma;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public int getHijos() {
        return hijos;
    }
}


