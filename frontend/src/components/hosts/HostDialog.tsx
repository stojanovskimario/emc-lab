import { useEffect, useState } from 'react';
import { Button, Dialog, DialogActions, DialogContent, DialogTitle, MenuItem, Stack, TextField } from '@mui/material';
import type { Host } from '../../types/host';
import type { Country } from '../../types/country';
import type { CreateHostRequest } from '../../types/requests';

interface HostDialogProps {
  open: boolean;
  host?: Host | null;
  countries: Country[];
  onClose: () => void;
  onSubmit: (payload: CreateHostRequest) => Promise<void>;
}

const HostDialog = ({ open, host, countries, onClose, onSubmit }: HostDialogProps) => {
  const [form, setForm] = useState({ name: '', surname: '', countryId: '' });
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    if (host) {
      setForm({ name: host.name, surname: host.surname, countryId: String(host.countryId) });
      return;
    }

    setForm({ name: '', surname: '', countryId: countries[0] ? String(countries[0].id) : '' });
  }, [countries, host, open]);

  const handleSubmit = async () => {
    setSubmitting(true);
    try {
      await onSubmit({
        name: form.name.trim(),
        surname: form.surname.trim(),
        countryId: Number(form.countryId)
      });
      onClose();
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="sm">
      <DialogTitle>{host ? 'Edit host' : 'Add host'}</DialogTitle>
      <DialogContent>
        <Stack spacing={2} sx={{ pt: 1 }}>
          <TextField label="Name" value={form.name} onChange={(event) => setForm({ ...form, name: event.target.value })} fullWidth />
          <TextField
            label="Surname"
            value={form.surname}
            onChange={(event) => setForm({ ...form, surname: event.target.value })}
            fullWidth
          />
          <TextField
            select
            label="Country"
            value={form.countryId}
            onChange={(event) => setForm({ ...form, countryId: event.target.value })}
            fullWidth
          >
            {countries.map((country) => (
              <MenuItem key={country.id} value={country.id}>
                {country.name}
              </MenuItem>
            ))}
          </TextField>
        </Stack>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button onClick={handleSubmit} variant="contained" disabled={submitting || !form.countryId}>
          {submitting ? 'Saving...' : 'Save'}
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default HostDialog;

