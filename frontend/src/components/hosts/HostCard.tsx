import { Card, CardContent, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Host } from '../../types/host';

interface HostCardProps {
  host: Host;
}

const HostCard = ({ host }: HostCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }} component={Link} to={`/hosts/${host.id}`} style={{ textDecoration: 'none' }}>
      <CardContent>
        <Stack spacing={1}>
          <Typography variant="h6">
            {host.name} {host.surname}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Host ID: {host.id}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Country ID: {host.countryId}
          </Typography>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default HostCard;

