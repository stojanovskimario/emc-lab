import { Box, Button, Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import HostCard from '../components/hosts/HostCard';
import HostDialog from '../components/hosts/HostDialog';
import { useHosts } from '../hooks/useHosts';
import { useHostActions } from '../hooks/useHostActions';
import { useCountries } from '../hooks/useCountries';
import { useCurrentUser } from '../hooks/useCurrentUser';
import { useState } from 'react';
import type { Host } from '../types/host';

const HostsPage = () => {
  const { items: hosts, loading, error, refetch } = useHosts();
  const { items: countries } = useCountries();
  const { item: currentUser } = useCurrentUser();
  const { createHost, updateHost, deleteHost } = useHostActions(refetch);
  const [dialogOpen, setDialogOpen] = useState(false);
  const [editingHost, setEditingHost] = useState<Host | null>(null);
  const isAdmin = currentUser?.role === 'ROLE_ADMINISTRATOR';

  const openCreateDialog = () => {
    setEditingHost(null);
    setDialogOpen(true);
  };

  const openEditDialog = (host: Host) => {
    setEditingHost(host);
    setDialogOpen(true);
  };

  const closeDialog = () => {
    setDialogOpen(false);
    setEditingHost(null);
  };

  const handleDelete = async (host: Host) => {
    if (window.confirm(`Delete host '${host.name} ${host.surname}'?`)) {
      await deleteHost(host.id);
    }
  };

  return (
    <Stack spacing={3}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', gap: 2, flexWrap: 'wrap' }}>
        <Typography variant="h4" component="h1">
          Hosts
        </Typography>
        {isAdmin && (
          <Button variant="contained" onClick={openCreateDialog}>
            Add host
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
          {hosts.map((host) => (
            <HostCard
              key={host.id}
              host={host}
              canEdit={isAdmin}
              onEdit={() => openEditDialog(host)}
              onDelete={() => void handleDelete(host)}
            />
          ))}
        </Stack>
      )}

      <HostDialog
        open={dialogOpen}
        host={editingHost}
        countries={countries}
        onClose={closeDialog}
        onSubmit={async (payload) => {
          if (editingHost) {
            await updateHost(editingHost.id, payload);
            return;
          }

          await createHost(payload);
        }}
      />
    </Stack>
  );
};

export default HostsPage;

