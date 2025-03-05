import { BASE_URL } from '@/constants/API';
import { apiClient } from "@/config/axiosConfig";
import { Paciente } from "@/interfaces/paciente.interface";

export const PacienteService = {
    register: async (paciente: Omit<Paciente, 'id'>): Promise<Paciente> => {
        const response = await apiClient.post(`${BASE_URL}/pacientes/registrar`, paciente);
        return response.data;
    },
    getAll: async (): Promise<Paciente[]> => {
        const response = await apiClient.get(`${BASE_URL}/pacientes`);
        return response.data;
    },

    getById: async (id: string): Promise<Paciente> => {
        const response = await apiClient.get(`${BASE_URL}/pacientes/${id}`);
        return response.data;
    },


    update: async (id: string, paciente: Partial<Paciente>): Promise<Paciente> => {
        const response = await apiClient.put(`${BASE_URL}/pacientes/${id}`, paciente);
        return response.data;
    },

    delete: async (id: string): Promise<void> => {
        await apiClient.delete(`${BASE_URL}/pacientes/${id}`);
    }
};