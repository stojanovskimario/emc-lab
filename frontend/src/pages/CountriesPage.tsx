import { Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import CountryCard from '../components/countries/CountryCard';
import { useCountries } from '../hooks/useCountries';

const CountriesPage = () => {
  const { items: countries, loading, error } = useCountries();

  return (
    <Stack spacing={3}>
      <Typography variant="h4" component="h1">
        Countries
      </Typography>
      {loading && <LoadingState />}
      {!loading && error && <ErrorState message={error} />}
      {!loading && !error && (
        <Stack
          sx={{
            display: 'grid',
            gridTemplateColumns: { xs: '1fr', sm: 'repeat(2, 1fr)', lg: 'repeat(3, 1fr)' },
            gap: 2
          }}
        >
          {countries.map((country) => (
            <CountryCard key={country.id} country={country} />
          ))}
        </Stack>
      )}
    </Stack>
  );
};

export default CountriesPage;

