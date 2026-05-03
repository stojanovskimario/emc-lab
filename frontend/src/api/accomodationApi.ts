import axiosInstance from './axiosInstance';
import type { Accomodation } from '../types/accomodation';

const accomodationApi = {
  findAll: async (): Promise<Accomodation[]> => {
    const response = await axiosInstance.get<Accomodation[]>('/accomodations');
    return response.data;
  },

  findById: async (id: string): Promise<Accomodation> => {
    const response = await axiosInstance.get<Accomodation>(`/accomodations/${id}`);
    return response.data;
  }
};

export default accomodationApi;

