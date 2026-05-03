import countryApi from '../api/countryApi';
import useAsyncList from './useAsyncList';

export const useCountries = () => {
  return useAsyncList(countryApi.findAll);
};


