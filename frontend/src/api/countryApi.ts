import axiosInstance from './axiosInstance';
import type { Country } from '../types/country';
import type { CreateCountryRequest } from '../types/requests';

const countryApi = {
  findAll: async (): Promise<Country[]> => {
    const response = await axiosInstance.get<Country[]>('/countries');
    return response.data;
  },

  findById: async (id: string): Promise<Country> => {
    const response = await axiosInstance.get<Country>(`/countries/${id}`);
    return response.data;
  },

  create: async (country: CreateCountryRequest): Promise<Country> => {
    const response = await axiosInstance.post<Country>('/countries/add', country);
    return response.data;
  },

  update: async (id: number, country: CreateCountryRequest): Promise<Country> => {
    const response = await axiosInstance.put<Country>(`/countries/${id}/edit`, country);
    return response.data;
  },

  deleteById: async (id: number): Promise<Country> => {
    const response = await axiosInstance.delete<Country>(`/countries/${id}/delete`);
    return response.data;
  }
};

export default countryApi;

