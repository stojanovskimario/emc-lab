import { Box, Card, CardContent, Chip, Typography } from '@mui/material';
import type { Reservation } from '../../types/reservation';

interface ReservationCardProps {
  reservation: Reservation;
}

export const ReservationCard = ({ reservation }: ReservationCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }}>
      <CardContent>
        <Box sx={{ display: 'flex', flexDirection: 'column', gap: 1.5 }}>
          <Typography variant="h6">Reservation #{reservation.id}</Typography>
          <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
            <Chip label={reservation.accommodationName} color="primary" size="small" />
            <Chip label={reservation.userName} variant="outlined" size="small" />
          </Box>
          <Typography variant="body2" color="text.secondary">
            User ID: {reservation.userId}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Accommodation ID: {reservation.accommodationId}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Reserved at: {reservation.reservedAt}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Release at: {reservation.releaseAt}
          </Typography>
        </Box>
      </CardContent>
    </Card>
  );
};

export default ReservationCard;

