import { useQuery } from '@tanstack/react-query';
import { PacienteService } from '@/services/paciene.service';

export const usePacienteQueries = () => {
  const usePatients = () => {
    return useQuery({
      queryKey: ['pacientes'],
      queryFn: PacienteService.getAll,
    });
  };

  const usePatientById = (id?: string) => {
    return useQuery({
      queryKey: ['pacientes', id],
      queryFn: () => PacienteService.getById(id!),
      enabled: !!id, 
      staleTime: 1000 * 60 * 5, 
    });
  };

  return { usePatients, usePatientById };
};