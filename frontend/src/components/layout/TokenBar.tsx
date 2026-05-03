import { useEffect, useState } from 'react';
import { Box, Button, Stack, TextField, Typography } from '@mui/material';

const STORAGE_KEY = 'jwtToken';

const TokenBar = () => {
  const [token, setToken] = useState('');

  useEffect(() => {
    const savedToken = localStorage.getItem(STORAGE_KEY);
    if (savedToken) {
      setToken(savedToken);
    }
  }, []);

  const handleSave = () => {
    const normalizedToken = token.trim();
    if (normalizedToken) {
      localStorage.setItem(STORAGE_KEY, normalizedToken);
    } else {
      localStorage.removeItem(STORAGE_KEY);
    }
    window.location.reload();
  };

  const handleClear = () => {
    localStorage.removeItem(STORAGE_KEY);
    setToken('');
    window.location.reload();
  };

  return (
    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, flexWrap: 'wrap' }}>
      <Box>
        <Typography variant="caption" sx={{ display: 'block', color: 'rgba(255,255,255,0.8)' }}>
          JWT token
        </Typography>
        <TextField
          size="small"
          value={token}
          onChange={(event) => setToken(event.target.value)}
          placeholder="Paste token here"
          sx={{ width: 320, bgcolor: 'white', borderRadius: 1 }}
        />
      </Box>
      <Stack direction="row" spacing={1}>
        <Button variant="contained" color="secondary" onClick={handleSave}>
          Save
        </Button>
        <Button variant="outlined" color="inherit" onClick={handleClear}>
          Clear
        </Button>
      </Stack>
    </Box>
  );
};

export default TokenBar;


