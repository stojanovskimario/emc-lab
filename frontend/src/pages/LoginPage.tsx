import { useState } from 'react';
import { Alert, Box, Button, Paper, Stack, TextField, Typography } from '@mui/material';
import { Link, useLocation } from 'react-router-dom';
import userApi from '../api/userApi';
import type { LoginUserRequest } from '../types/requests';

const LoginPage = () => {
  const location = useLocation();
  const [form, setForm] = useState<LoginUserRequest>({ username: '', password: '' });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const handleChange = (field: keyof LoginUserRequest) => (event: React.ChangeEvent<HTMLInputElement>) => {
    setForm((previousState) => ({ ...previousState, [field]: event.target.value }));
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setLoading(true);
    setError(null);

    try {
      const response = await userApi.login(form);
      localStorage.setItem('jwtToken', response.token);
      const redirectTo = (location.state as { from?: Location } | null)?.from?.pathname ?? '/accommodations';
      window.location.assign(redirectTo);
    } catch (submitError) {
      console.error(submitError);
      setError('Unable to log in. Please check your credentials.');
      setLoading(false);
    }
  };

  return (
    <Box sx={{ display: 'flex', justifyContent: 'center' }}>
      <Paper elevation={2} sx={{ p: 4, width: '100%', maxWidth: 520 }}>
        <Stack spacing={3} component="form" onSubmit={handleSubmit}>
          <Box>
            <Typography variant="h4" component="h1" gutterBottom>
              Login
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Use your JWT-enabled account to continue.
            </Typography>
          </Box>

          {error && <Alert severity="error">{error}</Alert>}

          <TextField label="Username" value={form.username} onChange={handleChange('username')} required fullWidth />
          <TextField
            label="Password"
            type="password"
            value={form.password}
            onChange={handleChange('password')}
            required
            fullWidth
          />

          <Button type="submit" variant="contained" disabled={loading}>
            {loading ? 'Logging in...' : 'Login'}
          </Button>

          <Typography variant="body2">
            Need an account? <Link to="/register">Register here</Link>
          </Typography>
        </Stack>
      </Paper>
    </Box>
  );
};

export default LoginPage;

