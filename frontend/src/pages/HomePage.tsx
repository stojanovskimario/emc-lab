import { Alert, Box, Paper, Stack, Typography } from '@mui/material';

const HomePage = () => {
  return (
    <Stack spacing={3}>
      <Paper elevation={0} sx={{ p: 4, border: '1px solid', borderColor: 'divider', borderRadius: 3 }}>
        <Stack spacing={2}>
          <Typography variant="h3" component="h1">
            Accommodation rental UI
          </Typography>
          <Typography variant="body1" color="text.secondary">
            Use the navigation bar to browse accommodations, hosts, and countries.
          </Typography>
          <Alert severity="info">
            If the backend is protected, paste your JWT token in the header and save it once.
          </Alert>
        </Stack>
      </Paper>

      <Box
        sx={{
          display: 'grid',
          gridTemplateColumns: { xs: '1fr', md: 'repeat(3, 1fr)' },
          gap: 2
        }}
      >
        <Paper sx={{ p: 3, borderRadius: 3 }}>
          <Typography variant="h6">/accommodations</Typography>
          <Typography variant="body2" color="text.secondary">
            Browse all accommodations from the Spring API.
          </Typography>
        </Paper>
        <Paper sx={{ p: 3, borderRadius: 3 }}>
          <Typography variant="h6">/hosts</Typography>
          <Typography variant="body2" color="text.secondary">
            See all hosts and their country references.
          </Typography>
        </Paper>
        <Paper sx={{ p: 3, borderRadius: 3 }}>
          <Typography variant="h6">/countries</Typography>
          <Typography variant="body2" color="text.secondary">
            List all countries stored in the backend.
          </Typography>
        </Paper>
      </Box>
    </Stack>
  );
};

export default HomePage;

