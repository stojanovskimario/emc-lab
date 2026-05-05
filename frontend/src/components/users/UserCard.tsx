import { Card, CardContent, Chip, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { User } from '../../types/user';

interface UserCardProps {
  user: User;
}

const UserCard = ({ user }: UserCardProps) => {
  return (
    <Card
      variant="outlined"
      sx={{ height: '100%' }}
      component={Link}
      to={`/users/${user.id}`}
      style={{ textDecoration: 'none' }}
    >
      <CardContent>
        <Stack spacing={1.2}>
          <Typography variant="h6">
            {user.name} {user.surname}
          </Typography>
          <Chip
            label={user.role}
            color={user.role === 'ROLE_ADMINISTRATOR' ? 'warning' : 'primary'}
            size="small"
            sx={{ alignSelf: 'flex-start' }}
          />
          <Typography variant="body2" color="text.secondary">
            Username: {user.username}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Email: {user.email}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            User ID: {user.id}
          </Typography>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default UserCard;

