import { Box, Button, Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import AccommodationCard from '../components/accommodations/AccommodationCard';
import AccommodationDialog from '../components/accommodations/AccommodationDialog';
import { useAccommodations } from '../hooks/useAccommodations';
import { useAccommodationActions } from '../hooks/useAccommodationActions';
import { useHosts } from '../hooks/useHosts';
import { useCurrentUser } from '../hooks/useCurrentUser';
import { useState } from 'react';
import type { Accomodation } from '../types/accomodation';

const AccommodationsPage = () => {
  const { items: accommodations, loading, error, refetch } = useAccommodations();
  const { items: hosts } = useHosts();
  const { item: currentUser } = useCurrentUser();
  const { createAccommodation, updateAccommodation, deleteAccommodation, toggleAccommodationRented } =
    useAccommodationActions(refetch);
  const [dialogOpen, setDialogOpen] = useState(false);
  const [editingAccommodation, setEditingAccommodation] = useState<Accomodation | null>(null);
  const isAdmin = currentUser?.role === 'ROLE_ADMINISTRATOR';

  const openCreateDialog = () => {
    setEditingAccommodation(null);
    setDialogOpen(true);
  };

  const openEditDialog = (accommodation: Accomodation) => {
    setEditingAccommodation(accommodation);
    setDialogOpen(true);
  };

  const closeDialog = () => {
    setDialogOpen(false);
    setEditingAccommodation(null);
  };

  const handleDelete = async (accommodation: Accomodation) => {
    if (window.confirm(`Delete accommodation '${accommodation.name}'?`)) {
      await deleteAccommodation(accommodation.id);
    }
  };

  const handleToggleRented = async (accommodation: Accomodation) => {
    await toggleAccommodationRented(accommodation.id);
  };

  return (
    <Stack spacing={3}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 2, flexWrap: 'wrap' }}>
        <Typography variant="h4" component="h1">
          Accommodations
        </Typography>
        {isAdmin && (
          <Button variant="contained" onClick={openCreateDialog}>
            Add accommodation
          </Button>
        )}
      </Box>
      {loading && <LoadingState />}
      {!loading && error && <ErrorState message={error} />}
      {!loading && !error && (
        <Stack
          sx={{
            display: 'grid',
            gridTemplateColumns: { xs: '1fr', sm: 'repeat(2, 1fr)', lg: 'repeat(3, 1fr)' },
            gap: 2
          }}
        >
          {accommodations.map((accommodation) => (
            <AccommodationCard
              key={accommodation.id}
              accommodation={accommodation}
              canEdit={isAdmin}
              onEdit={() => openEditDialog(accommodation)}
              onDelete={() => void handleDelete(accommodation)}
              onToggleRented={() => void handleToggleRented(accommodation)}
            />
          ))}
        </Stack>
      )}

      <AccommodationDialog
        open={dialogOpen}
        accommodation={editingAccommodation}
        hosts={hosts}
        onClose={closeDialog}
        onSubmit={async (payload) => {
          if (editingAccommodation) {
            await updateAccommodation(editingAccommodation.id, payload);
            return;
          }

          await createAccommodation(payload);
        }}
      />
    </Stack>
  );
};

export default AccommodationsPage;

