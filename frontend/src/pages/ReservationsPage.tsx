import { useState } from 'react';
import { Box, Button, Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import { ReservationCard } from '../components/reservations/ReservationCard';
import ReservationDialog from '../components/reservations/ReservationDialog';
import { useReservations } from '../hooks/useReservations';
import { useReservationActions } from '../hooks/useReservationActions';

const ReservationsPage = () => {
  const { items: reservations, loading, error, refetch } = useReservations();
  const { reserveReservation } = useReservationActions(refetch);
  const [dialogOpen, setDialogOpen] = useState(false);

  return (
    <Stack spacing={3}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 2, flexWrap: 'wrap' }}>
        <Typography variant="h4" component="h1">
          Reservations
        </Typography>
        <Button variant="contained" onClick={() => setDialogOpen(true)}>
          Add Reservation
        </Button>
      </Box>

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
          {reservations.map((reservation) => (
            <ReservationCard key={reservation.id} reservation={reservation} />
          ))}
        </Stack>
      )}

      <ReservationDialog
        open={dialogOpen}
        onClose={() => setDialogOpen(false)}
        onSubmit={async (payload) => {
          await reserveReservation(payload);
        }}
      />
    </Stack>
  );
};

export default ReservationsPage;


