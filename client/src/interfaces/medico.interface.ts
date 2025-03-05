export interface Medico {
    id: number,
    nombre: string,
    edad: number,
    genero: "FEMENINO" | "MASCULINO",
    telefono: number,
    especialidad: Specialty,
    direccion: string
}

export type Specialty = "ORTOPEDIA" | "PEDIATRIA" | "ODONTOLOGIA";

