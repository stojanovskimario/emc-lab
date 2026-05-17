import { useCallback } from 'react';
import hostApi from '../api/hostApi';
import type { CreateHostRequest } from '../types/requests';

export const useHostActions = (refetch: () => Promise<void>) => {
  const createHost = useCallback(
    async (payload: CreateHostRequest) => {
      await hostApi.create(payload);
      await refetch();
    },
    [refetch]
  );

  const updateHost = useCallback(
    async (id: number, payload: CreateHostRequest) => {
      await hostApi.update(id, payload);
      await refetch();
    },
    [refetch]
  );

  const deleteHost = useCallback(
    async (id: number) => {
      await hostApi.deleteById(id);
      await refetch();
    },
    [refetch]
  );

  return {
    createHost,
    updateHost,
    deleteHost
  };
};

