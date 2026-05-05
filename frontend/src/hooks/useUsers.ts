import type { User } from '../types/user';
import { userApi } from '../api/userApi';
import useAsyncList, { type AsyncListState } from './useAsyncList';

export const useUsers = (): AsyncListState<User> => {
  return useAsyncList<User>(async () => userApi.findAll());
};





