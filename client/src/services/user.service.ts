import { apiClient } from "@/config/axiosConfig";
import { BASE_URL } from "@/constants/API";
import { User } from "@/interfaces/user.interface";

export const UserService = {
    getAll: async (): Promise<User[]> => {
        const response = await apiClient.get(`${BASE_URL}/usuario`)
        return response.data;
    },
    getById: async (id: number): Promise<User> => {
        const response = await apiClient.get(`${BASE_URL}/usuario/${id}`)
        return response.data
    },
    update: async (id: number, user: User): Promise<User> => {
        const response = await apiClient.put(`${BASE_URL}/usuario/${id}`, user)
        return response.data;
    },
    delete: async (id: string): Promise<void> => {
        await apiClient.delete(`${BASE_URL}/usuario/${id}`)
    }
};