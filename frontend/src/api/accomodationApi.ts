import axiosInstance from './axiosInstance';
import type { Accomodation } from '../types/accomodation';
import type { CreateAccommodationRequest } from '../types/requests';

const accomodationApi = {
  findAll: async (): Promise<Accomodation[]> => {
    const response = await axiosInstance.get<Accomodation[]>('/accomodations');
    return response.data;
  },

  findById: async (id: string): Promise<Accomodation> => {
    const response = await axiosInstance.get<Accomodation>(`/accomodations/${id}`);
    return response.data;
  },

  create: async (accommodation: CreateAccommodationRequest): Promise<Accomodation> => {
    const response = await axiosInstance.post<Accomodation>('/accomodations/add', accommodation);
    return response.data;
  },

  update: async (id: number, accommodation: CreateAccommodationRequest): Promise<Accomodation> => {
    const response = await axiosInstance.put<Accomodation>(`/accomodations/${id}/edit`, accommodation);
    return response.data;
  },

  deleteById: async (id: number): Promise<Accomodation> => {
    const response = await axiosInstance.delete<Accomodation>(`/accomodations/${id}/delete`);
    return response.data;
  },

  toggleRented: async (id: number): Promise<Accomodation> => {
    const response = await axiosInstance.put<Accomodation>(`/accomodations/${id}/toggle-rented`);
    return response.data;
  }
};

export default accomodationApi;

