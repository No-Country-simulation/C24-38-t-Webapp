import { apiClient } from "@/config/axiosConfig";
import { BASE_URL } from "@/constants/API";
import { Medico } from "@/interfaces/medico.interface";

export const MedicoService = {
    register: async (medico: Omit<Medico, "id">): Promise<Medico> => {
        const response = await apiClient.post(`${BASE_URL}/medicos/registrar`, medico)
        return response.data;
    },
    getAll: async (): Promise<Medico[]> => {
        const response = await apiClient.get(`${BASE_URL}/medicos/`)
        return response.data;
    },
    getById: async (id: number): Promise<Medico> => {
        const response = await apiClient.get(`${BASE_URL}/medicos/${id}`)
        return response.data;
    },
    update: async (id: string, medico: Omit<Medico, "id">): Promise<Medico> => {
        const response = await apiClient.put(`${BASE_URL}/medicos/${id}`, medico)
        return response.data;
    },
    delete: async (id: string) => {
        await apiClient.delete(`${BASE_URL}/medicos/${id}`)
    }

}