import reservationApi from '../api/reservationApi';
import useAsyncList from './useAsyncList';
import type { Reservation } from '../types/reservation';

export const useReservations = () => {
  return useAsyncList<Reservation>(reservationApi.findAll);
};

