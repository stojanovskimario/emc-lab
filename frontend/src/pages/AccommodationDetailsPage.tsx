import { useNavigate, useParams, Link } from 'react-router-dom';
import { ArrowBack } from '@mui/icons-material';
import { Box, Breadcrumbs, Button, Chip, CircularProgress, Paper, Stack, Typography } from '@mui/material';
import { useAccommodation } from '../hooks/useAccommodation';

const AccommodationDetailsPage = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const { item: accommodation, loading, error } = useAccommodation(id);

  if (loading) {
    return (
      <Box sx={{ display: 'flex', justifyContent: 'center', py: 8 }}>
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return <Typography color="error">{error}</Typography>;
  }

  if (!accommodation) {
    return <Typography>No accommodation found.</Typography>;
  }

  return (
    <Box>
      <Breadcrumbs sx={{ mb: 3 }}>
        <Link to="/accommodations" style={{ textDecoration: 'none', color: 'inherit' }}>
          Accommodations
        </Link>
        <Typography color="text.primary">{accommodation.name}</Typography>
      </Breadcrumbs>

      <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
        <Stack spacing={3}>
          <Box>
            <Typography variant="h3" gutterBottom sx={{ fontWeight: 600 }}>
              {accommodation.name}
            </Typography>
            <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
              <Chip label={accommodation.category} color="primary" />
              <Chip label={accommodation.status} variant="outlined" />
              <Chip label={accommodation.rented ? 'Rented' : 'Free'} color={accommodation.rented ? 'error' : 'success'} />
            </Box>
          </Box>

          <Typography variant="h6">Rooms: {accommodation.numRooms}</Typography>
          <Typography variant="body1">Host ID: {accommodation.hostId}</Typography>
          <Typography variant="body1">Accommodation ID: {accommodation.id}</Typography>

          <Box>
            <Button variant="outlined" startIcon={<ArrowBack />} onClick={() => navigate('/accommodations')}>
              Back to accommodations
            </Button>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
};

export default AccommodationDetailsPage;


