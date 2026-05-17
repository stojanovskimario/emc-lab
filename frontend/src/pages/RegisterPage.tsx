import { useState } from 'react';
import { Alert, Box, Button, Paper, Stack, TextField, Typography } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import userApi from '../api/userApi';

type RegisterForm = {
  name: string;
  surname: string;
  email: string;
  username: string;
  password: string;
};

const initialForm: RegisterForm = {
  name: '',
  surname: '',
  email: '',
  username: '',
  password: ''
};

const RegisterPage = () => {
  const navigate = useNavigate();
  const [form, setForm] = useState<RegisterForm>(initialForm);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const handleChange = (field: keyof RegisterForm) => (event: React.ChangeEvent<HTMLInputElement>) => {
    setForm((previousState: RegisterForm) => ({ ...previousState, [field]: event.target.value }));
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setLoading(true);
    setError(null);

    try {
      await userApi.register(form);
      navigate('/login');
    } catch (submitError) {
      console.error(submitError);
      setError('Unable to register. Please verify the data and try again.');
      setLoading(false);
    }
  };

  return (
    <Box sx={{ display: 'flex', justifyContent: 'center' }}>
      <Paper elevation={2} sx={{ p: 4, width: '100%', maxWidth: 640 }}>
        <Stack spacing={3} component="form" onSubmit={handleSubmit}>
          <Box>
            <Typography variant="h4" component="h1" gutterBottom>
              Register
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Create a new account to access the protected pages.
            </Typography>
          </Box>

          {error && <Alert severity="error">{error}</Alert>}

          <Stack spacing={2} direction={{ xs: 'column', md: 'row' }}>
            <TextField label="Name" value={form.name} onChange={handleChange('name')} required fullWidth />
            <TextField label="Surname" value={form.surname} onChange={handleChange('surname')} required fullWidth />
          </Stack>

          <TextField label="Email" type="email" value={form.email} onChange={handleChange('email')} required fullWidth />
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
            {loading ? 'Registering...' : 'Register'}
          </Button>

          <Typography variant="body2">
            Already have an account? <Link to="/login">Login here</Link>
          </Typography>
        </Stack>
      </Paper>
    </Box>
  );
};

export default RegisterPage;


