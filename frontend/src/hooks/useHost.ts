import { useCallback } from 'react';
import hostApi from '../api/hostApi';
import useAsyncResource from './useAsyncResource';

export const useHost = (id?: string) => {
  const fetcher = useCallback(async () => {
    if (!id) {
      throw new Error('Host id is missing');
    }

    return hostApi.findById(id);
  }, [id]);

  return useAsyncResource(fetcher);
};

