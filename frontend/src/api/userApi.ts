import axiosInstance from './axiosInstance';
import type { User } from '../types/user';
import type { LoginUserRequest, RegisterUserRequest } from '../types/requests';

export const userApi = {
  findAll: async (): Promise<User[]> => {
    const response = await axiosInstance.get<User[]>('/users');
    return response.data;
  },

  findById: async (id: string): Promise<User> => {
    const response = await axiosInstance.get<User>(`/users/${id}`);
    return response.data;
  },

  login: async (payload: LoginUserRequest): Promise<{ token: string }> => {
    const response = await axiosInstance.post<{ token: string }>('/user/login', payload);
    return response.data;
  },

  register: async (payload: RegisterUserRequest): Promise<User> => {
    const response = await axiosInstance.post<User>('/user/register', payload);
    return response.data;
  },

  me: async (): Promise<User> => {
    const response = await axiosInstance.get<User>('/user/me');
    return response.data;
  }
};

export default userApi;


