import { useCallback } from 'react';
import type { User } from '../types/user';
import userApi from '../api/userApi';
import useAsyncResource, { type AsyncResourceState } from './useAsyncResource';

export const useCurrentUser = (enabled = true): AsyncResourceState<User> => {
  const fetcher = useCallback(async () => {
    return userApi.me();
  }, []);

  return useAsyncResource<User>(fetcher, enabled);
};

