import { usePacienteQueries } from './queries/usePacienteQueries';
import { usePacienteMutations } from './mutations/usePacienteMutations';

export const usePaciente = () => {
  const queries = usePacienteQueries();
  const mutations = usePacienteMutations();





  return {
    ...queries,
    ...mutations,

  };
};