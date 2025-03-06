import { useMutation, useQueryClient } from '@tanstack/react-query';
import { PacienteService } from '@/services/paciene.service';
import { Paciente } from '@/interfaces/paciente.interface';

export const usePacienteMutations = () => {
  const queryClient = useQueryClient();

  const createPatient = useMutation({
    mutationFn: (paciente: Omit<Paciente, 'id'>) => {
      return PacienteService.register(paciente);
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['pacientes'] });
    }
  });

  
  const updatePatient = useMutation({
    mutationFn: ({ id, patient }: { id: string; patient: Partial<Paciente> }) => {
      return PacienteService.update(id, patient);
    },
    onSuccess: (data) => {
      queryClient.invalidateQueries({ queryKey: ['pacientes'] });
      queryClient.invalidateQueries({ queryKey: ['pacientes', data.id.toString()] });
    }
  });

 
  const deletePatient = useMutation({
    mutationFn: (id: string) => {
      return PacienteService.delete(id);
    },
    onSuccess: (_data, id) => {
      queryClient.invalidateQueries({ queryKey: ['pacientes'] });
      queryClient.removeQueries({ queryKey: ['pacientes', id] });
    }
  });

  return {
    createPatient: createPatient.mutate,
    isCreatingPatient: createPatient.isPending,
    createPatientError: createPatient.error,

    updatePatient: updatePatient.mutate,
    isUpdatingPatient: updatePatient.isPending,
    updatePatientError: updatePatient.error,

    deletePatient: deletePatient.mutate,
    isDeletingPatient: deletePatient.isPending,
    deletePatientError: deletePatient.error
  };
};