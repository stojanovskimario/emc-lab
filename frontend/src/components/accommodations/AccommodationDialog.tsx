import { useEffect, useState } from 'react';
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Button,
  MenuItem,
  Stack,
  TextField
} from '@mui/material';
import type { Accomodation, Category, Status } from '../../types/accomodation';
import type { Host } from '../../types/host';
import type { CreateAccommodationRequest } from '../../types/requests';

interface AccommodationDialogProps {
  open: boolean;
  accommodation?: Accomodation | null;
  hosts: Host[];
  onClose: () => void;
  onSubmit: (payload: CreateAccommodationRequest) => Promise<void>;
}

const categories: Category[] = ['APARTMENT', 'HOUSE', 'MOTEL', 'HOTEL', 'FLAT', 'ROOM'];
const statuses: Status[] = ['GOOD', 'BAD', 'NEW', 'RENOVATED'];

const AccommodationDialog = ({ open, accommodation, hosts, onClose, onSubmit }: AccommodationDialogProps) => {
  const [form, setForm] = useState({
    name: '',
    category: 'APARTMENT' as Category,
    status: 'NEW' as Status,
    numRooms: '0',
    hostId: '',
    rented: false
  });
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    if (accommodation) {
      setForm({
        name: accommodation.name,
        category: accommodation.category,
        status: accommodation.status,
        numRooms: String(accommodation.numRooms),
        hostId: String(accommodation.hostId),
        rented: accommodation.rented
      });
      return;
    }

    setForm({
      name: '',
      category: 'APARTMENT',
      status: 'NEW',
      numRooms: '0',
      hostId: hosts[0] ? String(hosts[0].id) : '',
      rented: false
    });
  }, [accommodation, hosts, open]);

  const handleSubmit = async () => {
    setSubmitting(true);
    try {
      await onSubmit({
        name: form.name.trim(),
        category: form.category,
        status: form.status,
        numRooms: Number(form.numRooms),
        hostId: Number(form.hostId),
        rented: form.rented
      });
      onClose();
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="sm">
      <DialogTitle>{accommodation ? 'Edit accommodation' : 'Add accommodation'}</DialogTitle>
      <DialogContent>
        <Stack spacing={2} sx={{ pt: 1 }}>
          <TextField
            label="Name"
            value={form.name}
            onChange={(event) => setForm((previousState) => ({ ...previousState, name: event.target.value }))}
            fullWidth
          />
          <TextField
            select
            label="Category"
            value={form.category}
            onChange={(event) => setForm((previousState) => ({ ...previousState, category: event.target.value as Category }))}
            fullWidth
          >
            {categories.map((category) => (
              <MenuItem key={category} value={category}>
                {category}
              </MenuItem>
            ))}
          </TextField>
          <TextField
            select
            label="Status"
            value={form.status}
            onChange={(event) => setForm((previousState) => ({ ...previousState, status: event.target.value as Status }))}
            fullWidth
          >
            {statuses.map((status) => (
              <MenuItem key={status} value={status}>
                {status}
              </MenuItem>
            ))}
          </TextField>
          <TextField
            label="Number of rooms"
            type="number"
            value={form.numRooms}
            onChange={(event) => setForm((previousState) => ({ ...previousState, numRooms: event.target.value }))}
            fullWidth
          />
          <TextField
            select
            label="Host"
            value={form.hostId}
            onChange={(event) => setForm((previousState) => ({ ...previousState, hostId: event.target.value }))}
            fullWidth
          >
            {hosts.map((host) => (
              <MenuItem key={host.id} value={host.id}>
                {host.name} {host.surname}
              </MenuItem>
            ))}
          </TextField>
          <TextField
            select
            label="Rented"
            value={String(form.rented)}
            onChange={(event) => setForm((previousState) => ({ ...previousState, rented: event.target.value === 'true' }))}
            fullWidth
          >
            <MenuItem value="false">Free</MenuItem>
            <MenuItem value="true">Rented</MenuItem>
          </TextField>
        </Stack>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button onClick={handleSubmit} variant="contained" disabled={submitting || !form.hostId}>
          {submitting ? 'Saving...' : 'Save'}
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default AccommodationDialog;


