import { useCallback } from 'react';
import countryApi from '../api/countryApi';
import useAsyncResource from './useAsyncResource';

export const useCountry = (id?: string) => {
  const fetcher = useCallback(async () => {
    if (!id) {
      throw new Error('Country id is missing');
    }

    return countryApi.findById(id);
  }, [id]);

  return useAsyncResource(fetcher);
};

