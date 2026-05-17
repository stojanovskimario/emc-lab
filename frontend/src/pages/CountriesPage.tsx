import { Box, Button, Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import CountryCard from '../components/countries/CountryCard';
import CountryDialog from '../components/countries/CountryDialog';
import { useCountries } from '../hooks/useCountries';
import { useCountryActions } from '../hooks/useCountryActions';
import { useCurrentUser } from '../hooks/useCurrentUser';
import { useState } from 'react';
import type { Country } from '../types/country';

const CountriesPage = () => {
  const { items: countries, loading, error, refetch } = useCountries();
  const { item: currentUser } = useCurrentUser();
  const { createCountry, updateCountry, deleteCountry } = useCountryActions(refetch);
  const [dialogOpen, setDialogOpen] = useState(false);
  const [editingCountry, setEditingCountry] = useState<Country | null>(null);
  const isAdmin = currentUser?.role === 'ROLE_ADMINISTRATOR';

  const openCreateDialog = () => {
    setEditingCountry(null);
    setDialogOpen(true);
  };

  const openEditDialog = (country: Country) => {
    setEditingCountry(country);
    setDialogOpen(true);
  };

  const closeDialog = () => {
    setDialogOpen(false);
    setEditingCountry(null);
  };

  const handleDelete = async (country: Country) => {
    if (window.confirm(`Delete country '${country.name}'?`)) {
      await deleteCountry(country.id);
    }
  };

  return (
    <Stack spacing={3}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 2, flexWrap: 'wrap' }}>
        <Typography variant="h4" component="h1">
          Countries
        </Typography>
        {isAdmin && (
          <Button variant="contained" onClick={openCreateDialog}>
            Add country
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
          {countries.map((country) => (
            <CountryCard
              key={country.id}
              country={country}
              canEdit={isAdmin}
              onEdit={() => openEditDialog(country)}
              onDelete={() => void handleDelete(country)}
            />
          ))}
        </Stack>
      )}

      <CountryDialog
        open={dialogOpen}
        country={editingCountry}
        onClose={closeDialog}
        onSubmit={async (payload) => {
          if (editingCountry) {
            await updateCountry(editingCountry.id, payload);
            return;
          }

          await createCountry(payload);
        }}
      />
    </Stack>
  );
};

export default CountriesPage;

