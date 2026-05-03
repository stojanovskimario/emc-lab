import { useNavigate, useParams, Link } from 'react-router-dom';
import { ArrowBack } from '@mui/icons-material';
import { Box, Breadcrumbs, Button, CircularProgress, Paper, Stack, Typography } from '@mui/material';
import { useHost } from '../hooks/useHost';

const HostDetailsPage = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const { item: host, loading, error } = useHost(id);

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

  if (!host) {
    return <Typography>No host found.</Typography>;
  }

  return (
    <Box>
      <Breadcrumbs sx={{ mb: 3 }}>
        <Link to="/hosts" style={{ textDecoration: 'none', color: 'inherit' }}>
          Hosts
        </Link>
        <Typography color="text.primary">{host.name} {host.surname}</Typography>
      </Breadcrumbs>

      <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
        <Stack spacing={2}>
          <Typography variant="h3" sx={{ fontWeight: 600 }}>
            {host.name} {host.surname}
          </Typography>
          <Typography variant="body1">Host ID: {host.id}</Typography>
          <Typography variant="body1">Country ID: {host.countryId}</Typography>
          <Box>
            <Button variant="outlined" startIcon={<ArrowBack />} onClick={() => navigate('/hosts')}>
              Back to hosts
            </Button>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
};

export default HostDetailsPage;

