import { useEffect, useState } from 'react';
import { Button, Dialog, DialogActions, DialogContent, DialogTitle, Stack, TextField } from '@mui/material';
import type { Country } from '../../types/country';
import type { CreateCountryRequest } from '../../types/requests';

interface CountryDialogProps {
  open: boolean;
  country?: Country | null;
  onClose: () => void;
  onSubmit: (payload: CreateCountryRequest) => Promise<void>;
}

const CountryDialog = ({ open, country, onClose, onSubmit }: CountryDialogProps) => {
  const [form, setForm] = useState({ name: '', continent: '' });
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    if (country) {
      setForm({ name: country.name, continent: country.continent });
      return;
    }

    setForm({ name: '', continent: '' });
  }, [country, open]);

  const handleSubmit = async () => {
    setSubmitting(true);
    try {
      await onSubmit({ name: form.name.trim(), continent: form.continent.trim() });
      onClose();
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="sm">
      <DialogTitle>{country ? 'Edit country' : 'Add country'}</DialogTitle>
      <DialogContent>
        <Stack spacing={2} sx={{ pt: 1 }}>
          <TextField label="Name" value={form.name} onChange={(event) => setForm({ ...form, name: event.target.value })} fullWidth />
          <TextField
            label="Continent"
            value={form.continent}
            onChange={(event) => setForm({ ...form, continent: event.target.value })}
            fullWidth
          />
        </Stack>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button onClick={handleSubmit} variant="contained" disabled={submitting}>
          {submitting ? 'Saving...' : 'Save'}
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default CountryDialog;

