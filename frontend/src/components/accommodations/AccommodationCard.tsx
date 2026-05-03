import { Box, Card, CardContent, Chip, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Accomodation } from '../../types/accomodation';

interface AccommodationCardProps {
  accommodation: Accomodation;
}

const AccommodationCard = ({ accommodation }: AccommodationCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }} component={Link} to={`/accommodations/${accommodation.id}`} style={{ textDecoration: 'none' }}>
      <CardContent>
        <Stack spacing={1.5}>
          <Typography variant="h6">{accommodation.name}</Typography>
          <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
            <Chip label={accommodation.category} color="primary" size="small" />
            <Chip label={accommodation.status} variant="outlined" size="small" />
            <Chip
              label={accommodation.rented ? 'Rented' : 'Free'}
              color={accommodation.rented ? 'error' : 'success'}
              size="small"
            />
          </Box>
          <Typography variant="body2" color="text.secondary">
            Rooms: {accommodation.numRooms}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Host ID: {accommodation.hostId}
          </Typography>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default AccommodationCard;


