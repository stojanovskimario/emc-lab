import { useEffect, useState } from 'react';

export interface AsyncListState<T> {
  items: T[];
  loading: boolean;
  error: string | null;
}

const useAsyncList = <T,>(fetcher: () => Promise<T[]>) => {
  const [state, setState] = useState<AsyncListState<T>>({
    items: [],
    loading: true,
    error: null
  });

  useEffect(() => {
    let cancelled = false;

    const load = async () => {
      try {
        const items = await fetcher();
        if (!cancelled) {
          setState({ items, loading: false, error: null });
        }
      } catch (error) {
        console.error(error);
        if (!cancelled) {
          setState({ items: [], loading: false, error: 'Unable to load data.' });
        }
      }
    };

    load();

    return () => {
      cancelled = true;
    };
  }, [fetcher]);

  return state;
};

export default useAsyncList;

