import { useCallback } from 'react';
import reservationApi from '../api/reservationApi';
import type { CreateReservationRequest } from '../types/requests';

export const useReservationActions = (refetch: () => Promise<void>) => {
  const reserveReservation = useCallback(
    async (payload: CreateReservationRequest) => {
      await reservationApi.reserve(payload);
      await refetch();
    },
    [refetch]
  );

  return { reserveReservation };
};

