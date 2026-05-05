import { useNavigate, useParams, Link } from 'react-router-dom';
import { ArrowBack } from '@mui/icons-material';
import { Box, Breadcrumbs, Button, Chip, CircularProgress, Paper, Stack, Typography } from '@mui/material';
import { useUser } from '../hooks/useUser';

const UserDetailsPage = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const { item: user, loading, error } = useUser(id);

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

  if (!user) {
    return <Typography>No user found.</Typography>;
  }

  return (
    <Box>
      <Breadcrumbs sx={{ mb: 3 }}>
        <Link to="/users" style={{ textDecoration: 'none', color: 'inherit' }}>
          Users
        </Link>
        <Typography color="text.primary">
          {user.name} {user.surname}
        </Typography>
      </Breadcrumbs>

      <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
        <Stack spacing={3}>
          <Box>
            <Typography variant="h3" gutterBottom sx={{ fontWeight: 600 }}>
              {user.name} {user.surname}
            </Typography>
            <Chip
              label={user.role}
              color={user.role === 'ROLE_ADMINISTRATOR' ? 'warning' : 'primary'}
              sx={{ mr: 1 }}
            />
          </Box>

          <Typography variant="h6">Username: {user.username}</Typography>
          <Typography variant="body1">Email: {user.email}</Typography>
          <Typography variant="body1">User ID: {user.id}</Typography>

          <Box>
            <Button variant="outlined" startIcon={<ArrowBack />} onClick={() => navigate('/users')}>
              Back to users
            </Button>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
};

export default UserDetailsPage;

