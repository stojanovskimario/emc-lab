import axiosInstance from './axiosInstance';
import type { Reservation } from '../types/reservation';
import type { CreateReservationRequest } from '../types/requests';

const reservationApi = {
  findAll: async (): Promise<Reservation[]> => {
    const response = await axiosInstance.get<Reservation[]>('/reservations');
    return response.data;
  },

  reserve: async (payload: CreateReservationRequest): Promise<Reservation> => {
    const response = await axiosInstance.post<Reservation>('/reservations/reserve', payload);
    return response.data;
  }
};

export default reservationApi;

