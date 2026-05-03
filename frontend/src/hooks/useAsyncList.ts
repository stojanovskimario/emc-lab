import { useEffect, useState } from 'react';

interface AsyncListState<T> {
  items: T[];
  loading: boolean;
  error: string | null;
}

const initialState = {
  items: [],
  loading: true,
  error: null
};

const useAsyncList = <T,>(fetcher: () => Promise<T[]>) => {
  const [state, setState] = useState<AsyncListState<T>>(initialState);

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

