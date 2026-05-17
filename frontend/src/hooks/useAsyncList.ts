import { useEffect, useState } from 'react';

export interface AsyncListState<T> {
  items: T[];
  loading: boolean;
  error: string | null;
}

const useAsyncList = <T,>(fetcher: () => Promise<T[]>, enabled = true) => {
  const [state, setState] = useState<AsyncListState<T>>({
    items: [],
    loading: true,
    error: null
  });

  useEffect(() => {
    if (!enabled) {
      setState({ items: [], loading: false, error: null });
      return;
    }

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
  }, [enabled, fetcher]);

  const refetch = async () => {
    if (!enabled) {
      return;
    }

    setState((previousState) => ({ ...previousState, loading: true }));

    try {
      const items = await fetcher();
      setState({ items, loading: false, error: null });
    } catch (error) {
      console.error(error);
      setState({ items: [], loading: false, error: 'Unable to load data.' });
    }
  };

  return { ...state, refetch };
};

export default useAsyncList;

