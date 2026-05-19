import { useEffect, useState } from 'react';
import { Button, Dialog, DialogActions, DialogContent, DialogTitle, Stack, TextField } from '@mui/material';
import type { CreateReservationRequest } from '../../types/requests';

interface ReservationDialogProps {
  open: boolean;
  onClose: () => void;
  onSubmit: (payload: CreateReservationRequest) => Promise<void>;
}

const toDateTimeLocalValue = (date: Date) => {
  const localDate = new Date(date.getTime() - date.getTimezoneOffset() * 60000);
  return localDate.toISOString().slice(0, 16);
};

const ReservationDialog = ({ open, onClose, onSubmit }: ReservationDialogProps) => {
  const [form, setForm] = useState({
    accommodationId: '',
    reservedAt: toDateTimeLocalValue(new Date()),
    releaseAt: toDateTimeLocalValue(new Date(Date.now() + 24 * 60 * 60 * 1000))
  });
  const [submitting, setSubmitting] = useState(false);

  useEffect(() => {
    if (!open) {
      return;
    }

    setForm({
      accommodationId: '',
      reservedAt: toDateTimeLocalValue(new Date()),
      releaseAt: toDateTimeLocalValue(new Date(Date.now() + 24 * 60 * 60 * 1000))
    });
  }, [open]);

  const handleSubmit = async () => {
    setSubmitting(true);
    try {
      await onSubmit({
        accommodationId: Number(form.accommodationId),
        reservedAt: form.reservedAt,
        releaseAt: form.releaseAt
      });
      onClose();
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth maxWidth="sm">
      <DialogTitle>Add reservation</DialogTitle>
      <DialogContent>
        <Stack spacing={2} sx={{ pt: 1 }}>
          <TextField
            label="Accommodation ID"
            type="number"
            value={form.accommodationId}
            onChange={(event) => setForm((previousState) => ({ ...previousState, accommodationId: event.target.value }))}
            fullWidth
          />
          <TextField
            label="Reserved at"
            type="datetime-local"
            value={form.reservedAt}
            onChange={(event) => setForm((previousState) => ({ ...previousState, reservedAt: event.target.value }))}
            slotProps={{ inputLabel: { shrink: true } }}
            fullWidth
          />
          <TextField
            label="Release at"
            type="datetime-local"
            value={form.releaseAt}
            onChange={(event) => setForm((previousState) => ({ ...previousState, releaseAt: event.target.value }))}
            slotProps={{ inputLabel: { shrink: true } }}
            fullWidth
          />
        </Stack>
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button onClick={handleSubmit} variant="contained" disabled={submitting || !form.accommodationId}>
          {submitting ? 'Saving...' : 'Save'}
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default ReservationDialog;

