import axiosInstance from './axiosInstance';
import type { Country } from '../types/country';

const countryApi = {
  findAll: async (): Promise<Country[]> => {
    const response = await axiosInstance.get<Country[]>('/countries');
    return response.data;
  },

  findById: async (id: string): Promise<Country> => {
    const response = await axiosInstance.get<Country>(`/countries/${id}`);
    return response.data;
  }
};

export default countryApi;

