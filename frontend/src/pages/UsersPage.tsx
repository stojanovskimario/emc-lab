import { Stack, Typography } from '@mui/material';
import LoadingState from '../components/common/LoadingState';
import ErrorState from '../components/common/ErrorState';
import UserCard from '../components/users/UserCard';
import { useUsers } from '../hooks/useUsers';
import type { User } from '../types/user';

const UsersPage = () => {
  const { items: users, loading, error } = useUsers() as {
    items: User[];
    loading: boolean;
    error: string | null;
  };

  return (
    <Stack spacing={3}>
      <Typography variant="h4" component="h1">
        Users
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
          {users.map((user) => (
            <UserCard key={user.id} user={user} />
          ))}
        </Stack>
      )}
    </Stack>
  );
};

export default UsersPage;


