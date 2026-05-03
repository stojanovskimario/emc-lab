import { useNavigate, useParams, Link } from 'react-router-dom';
import { ArrowBack } from '@mui/icons-material';
import { Box, Breadcrumbs, Button, CircularProgress, Paper, Stack, Typography } from '@mui/material';
import { useCountry } from '../hooks/useCountry';

const CountryDetailsPage = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const { item: country, loading, error } = useCountry(id);

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

  if (!country) {
    return <Typography>No country found.</Typography>;
  }

  return (
    <Box>
      <Breadcrumbs sx={{ mb: 3 }}>
        <Link to="/countries" style={{ textDecoration: 'none', color: 'inherit' }}>
          Countries
        </Link>
        <Typography color="text.primary">{country.name}</Typography>
      </Breadcrumbs>

      <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
        <Stack spacing={2}>
          <Typography variant="h3" sx={{ fontWeight: 600 }}>
            {country.name}
          </Typography>
          <Typography variant="body1">Country ID: {country.id}</Typography>
          <Typography variant="body1">Continent: {country.continent}</Typography>
          <Box>
            <Button variant="outlined" startIcon={<ArrowBack />} onClick={() => navigate('/countries')}>
              Back to countries
            </Button>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
};

export default CountryDetailsPage;

