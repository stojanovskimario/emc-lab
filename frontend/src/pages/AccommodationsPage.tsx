import { Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import AccommodationCard from '../components/accommodations/AccommodationCard';
import { useAccommodations } from '../hooks/useAccommodations';

const AccommodationsPage = () => {
  const { items: accommodations, loading, error } = useAccommodations();

  return (
    <Stack spacing={3}>
      <Typography variant="h4" component="h1">
        Accommodations
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
          {accommodations.map((accommodation) => (
            <AccommodationCard key={accommodation.id} accommodation={accommodation} />
          ))}
        </Stack>
      )}
    </Stack>
  );
};

export default AccommodationsPage;

