import { apiClient } from "@/config/axiosConfig";
import { BASE_URL } from "@/constants/API";
import { AuthResponse, LoginCredentials } from "@/interfaces/auth.interface";
import { Medico } from "@/interfaces/medico.interface";

export const AuthService = {

    login: async (credentials: LoginCredentials): Promise<AuthResponse> => {
        const response = await apiClient.post(`${BASE_URL}/usuario/iniciarSesion`, credentials);
        return response.data;
    },
    register: async (medico: Omit<Medico, 'id'>): Promise<Medico> => {
        const response = await apiClient.post(`${BASE_URL}/usuario/`, medico);
        return response.data;
    }

}