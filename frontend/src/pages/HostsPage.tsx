import { Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import HostCard from '../components/hosts/HostCard';
import { useHosts } from '../hooks/useHosts';

const HostsPage = () => {
  const { items: hosts, loading, error } = useHosts();

  return (
    <Stack spacing={3}>
      <Typography variant="h4" component="h1">
        Hosts
      </Typography>
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
            <HostCard key={host.id} host={host} />
          ))}
        </Stack>
      )}
    </Stack>
  );
};

export default HostsPage;

