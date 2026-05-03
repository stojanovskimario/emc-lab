import accomodationApi from '../api/accomodationApi';
import useAsyncList from './useAsyncList';

export const useAccommodations = () => {
  return useAsyncList(accomodationApi.findAll);
};


