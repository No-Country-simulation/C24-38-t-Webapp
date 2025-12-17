import { History } from '../interfaces/history.interface';
import { apiClient } from '../config/axiosConfig';
import { BASE_URL } from '@/constants/API';
export const HistoryService = {
   register: async (history: Omit<History, "id">): Promise<History> => {
      const response = await apiClient.post(`${BASE_URL}/historiales/registrar`, history)
      return response.data
   },
   getAll: async (): Promise<History[]> => {
      const response = await apiClient.get(`${BASE_URL}/historiales`)
      return response.data;
   },
   getById: async (id: number): Promise<History> => {
      const response = await apiClient.get(`${BASE_URL}/historiales/${id}`)
      return response.data;
   },
   delete: async (id: number): Promise<void> => {
      await apiClient.delete(`${BASE_URL}/historiales/${id}`)
   }
}