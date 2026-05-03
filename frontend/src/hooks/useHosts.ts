import hostApi from '../api/hostApi';
import useAsyncList from './useAsyncList';

export const useHosts = () => {
  return useAsyncList(hostApi.findAll);
};


