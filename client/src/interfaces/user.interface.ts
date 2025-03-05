export type UserType = "MEDICO" | "PACIENTE"

export interface User {
    id: number,
    document: string,
    email: string,
    password: string,
    typeUser: UserType,
    dateRegister: Date
}

