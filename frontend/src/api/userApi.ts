import axiosInstance from './axiosInstance';
import type { User } from '../types/user';

export const userApi = {
  findAll: async (): Promise<User[]> => {
    const response = await axiosInstance.get<User[]>('/users');
    return response.data;
  },

  findById: async (id: string): Promise<User> => {
    const response = await axiosInstance.get<User>(`/users/${id}`);
    return response.data;
  }
};

export default userApi;


