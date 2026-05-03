import { useCallback } from 'react';
import accomodationApi from '../api/accomodationApi';
import useAsyncResource from './useAsyncResource';

export const useAccommodation = (id?: string) => {
  const fetcher = useCallback(async () => {
    if (!id) {
      throw new Error('Accommodation id is missing');
    }

    return accomodationApi.findById(id);
  }, [id]);

  return useAsyncResource(fetcher);
};

