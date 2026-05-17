import { useCallback } from 'react';
import countryApi from '../api/countryApi';
import type { CreateCountryRequest } from '../types/requests';

export const useCountryActions = (refetch: () => Promise<void>) => {
  const createCountry = useCallback(
    async (payload: CreateCountryRequest) => {
      await countryApi.create(payload);
      await refetch();
    },
    [refetch]
  );

  const updateCountry = useCallback(
    async (id: number, payload: CreateCountryRequest) => {
      await countryApi.update(id, payload);
      await refetch();
    },
    [refetch]
  );

  const deleteCountry = useCallback(
    async (id: number) => {
      await countryApi.deleteById(id);
      await refetch();
    },
    [refetch]
  );

  return {
    createCountry,
    updateCountry,
    deleteCountry
  };
};

