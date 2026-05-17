import axiosInstance from './axiosInstance';
import type { Host } from '../types/host';
import type { CreateHostRequest } from '../types/requests';

const hostApi = {
  findAll: async (): Promise<Host[]> => {
    const response = await axiosInstance.get<Host[]>('/hosts');
    return response.data;
  },

  findById: async (id: string): Promise<Host> => {
    const response = await axiosInstance.get<Host>(`/hosts/${id}`);
    return response.data;
  },

  create: async (host: CreateHostRequest): Promise<Host> => {
    const response = await axiosInstance.post<Host>('/hosts/add', host);
    return response.data;
  },

  update: async (id: number, host: CreateHostRequest): Promise<Host> => {
    const response = await axiosInstance.put<Host>(`/hosts/${id}/edit`, host);
    return response.data;
  },

  deleteById: async (id: number): Promise<Host> => {
    const response = await axiosInstance.delete<Host>(`/hosts/${id}/delete`);
    return response.data;
  }
};

export default hostApi;

