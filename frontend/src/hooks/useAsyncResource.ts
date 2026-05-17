import { useCallback, useEffect, useState } from 'react';

export interface AsyncResourceState<T> {
  item: T | null;
  loading: boolean;
  error: string | null;
}

const useAsyncResource = <T,>(fetcher: () => Promise<T>, enabled = true) => {
  const [state, setState] = useState<AsyncResourceState<T>>({
    item: null,
    loading: true,
    error: null
  });

  const fetchResource = useCallback(async () => {
    if (!enabled) {
      setState({ item: null, loading: false, error: null });
      return;
    }

    setState((previousState) => ({ ...previousState, loading: true }));

    try {
      const item = await fetcher();
      setState({ item, loading: false, error: null });
    } catch (error) {
      console.error(error);
      setState({ item: null, loading: false, error: 'Unable to load data.' });
    }
  }, [enabled, fetcher]);

  useEffect(() => {
    void fetchResource();
  }, [fetchResource]);

  return { ...state, refetch: fetchResource };
};

export default useAsyncResource;

