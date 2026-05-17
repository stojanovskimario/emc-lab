import { Box, Button, Card, CardActions, CardContent, Chip, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Accomodation } from '../../types/accomodation';
import { Delete, Edit, Info, SwapHoriz } from '@mui/icons-material';

interface AccommodationCardProps {
  accommodation: Accomodation;
  canEdit?: boolean;
  onEdit?: () => void;
  onDelete?: () => void;
  onToggleRented?: () => void;
}

const AccommodationCard = ({ accommodation, canEdit, onEdit, onDelete, onToggleRented }: AccommodationCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }}>
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
      <CardActions sx={{ justifyContent: 'space-between', px: 2, pb: 2 }}>
        <Button component={Link} to={`/accommodations/${accommodation.id}`} startIcon={<Info />}>
          Info
        </Button>
        {canEdit && (
          <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
            <Button startIcon={<SwapHoriz />} color="secondary" onClick={onToggleRented}>
              Toggle rented
            </Button>
            <Button startIcon={<Edit />} color="warning" onClick={onEdit}>
              Edit
            </Button>
            <Button startIcon={<Delete />} color="error" onClick={onDelete}>
              Delete
            </Button>
          </Box>
        )}
      </CardActions>
    </Card>
  );
};

export default AccommodationCard;


