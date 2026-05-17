import { Outlet, NavLink } from 'react-router-dom';
import { AppBar, Box, Button, Container, Toolbar, Typography } from '@mui/material';
import TokenBar from './TokenBar';

const AppLayout = () => {
  const token = localStorage.getItem('jwtToken');

  const handleLogout = () => {
    localStorage.removeItem('jwtToken');
    window.location.assign('/');
  };

  return (
    <Box sx={{ minHeight: '100vh', bgcolor: 'grey.50' }}>
      <AppBar position="sticky" elevation={1} color="primary">
        <Toolbar sx={{ gap: 2, flexWrap: 'wrap' }}>
          <Typography variant="h6" component={NavLink} to="/" sx={{ color: 'inherit', textDecoration: 'none', mr: 2 }}>
            EMT Lab UI
          </Typography>

          <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap', flexGrow: 1 }}>
            <Button component={NavLink} to="/" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
              Home
            </Button>
            <Button component={NavLink} to="/accommodations" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
              Accommodations
            </Button>
            <Button component={NavLink} to="/hosts" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
              Hosts
            </Button>
            <Button component={NavLink} to="/countries" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
              Countries
            </Button>
            <Button component={NavLink} to="/users" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
              Users
            </Button>
            {!token && (
              <>
                <Button component={NavLink} to="/login" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
                  Login
                </Button>
                <Button component={NavLink} to="/register" color="inherit" sx={{ color: 'inherit', textDecoration: 'none' }}>
                  Register
                </Button>
              </>
            )}
            {token && (
              <Button color="inherit" onClick={handleLogout} sx={{ color: 'inherit', textDecoration: 'none' }}>
                Logout
              </Button>
            )}
          </Box>

          <TokenBar />
        </Toolbar>
      </AppBar>

      <Container maxWidth="xl" sx={{ py: 4 }}>
        <Outlet />
      </Container>
    </Box>
  );
};

export default AppLayout;


