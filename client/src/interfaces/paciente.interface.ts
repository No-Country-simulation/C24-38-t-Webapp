
export type Language = "ESPAÑOL" | "INGLES" | "RUSO" | "PORTUGUEZ"
export type MaritalStatus = "CASADO" | "DIVORSIADO" | "SOLTERO" | "VIUDO"
export interface Paciente {
    id: number,
    name: string,
    genero: "FEMENINO" | "MASCULINO",
    phone: number,
    capital: string,
    country: string,
    direction: string,
    age: number,
    bloodType: string,
    language: Language,
    maritalStatus: MaritalStatus,
    children: number
}



