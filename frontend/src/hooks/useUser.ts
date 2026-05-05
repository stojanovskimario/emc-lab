import { useCallback } from 'react';
import { userApi } from '../api/userApi';
import type { User } from '../types/user';
import useAsyncResource, { type AsyncResourceState } from './useAsyncResource';

export const useUser = (id?: string): AsyncResourceState<User> => {
  const fetcher = useCallback(async () => {
    if (!id) {
      throw new Error('User id is missing');
    }

    return userApi.findById(id);
  }, [id]);

  return useAsyncResource<User>(fetcher);
};




