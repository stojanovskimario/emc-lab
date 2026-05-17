import { useCallback } from 'react';
import accomodationApi from '../api/accomodationApi';
import type { CreateAccommodationRequest } from '../types/requests';

export const useAccommodationActions = (refetch: () => Promise<void>) => {
  const createAccommodation = useCallback(
    async (payload: CreateAccommodationRequest) => {
      await accomodationApi.create(payload);
      await refetch();
    },
    [refetch]
  );

  const updateAccommodation = useCallback(
    async (id: number, payload: CreateAccommodationRequest) => {
      await accomodationApi.update(id, payload);
      await refetch();
    },
    [refetch]
  );

  const deleteAccommodation = useCallback(
    async (id: number) => {
      await accomodationApi.deleteById(id);
      await refetch();
    },
    [refetch]
  );

  const toggleAccommodationRented = useCallback(
    async (id: number) => {
      await accomodationApi.toggleRented(id);
      await refetch();
    },
    [refetch]
  );

  return {
    createAccommodation,
    updateAccommodation,
    deleteAccommodation,
    toggleAccommodationRented
  };
};

