import { Button, Card, CardActions, CardContent, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Host } from '../../types/host';
import { Delete, Edit, Info } from '@mui/icons-material';

interface HostCardProps {
  host: Host;
  canEdit?: boolean;
  onEdit?: () => void;
  onDelete?: () => void;
}

const HostCard = ({ host, canEdit, onEdit, onDelete }: HostCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }}>
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
      <CardActions sx={{ justifyContent: 'space-between', px: 2, pb: 2 }}>
        <Button component={Link} to={`/hosts/${host.id}`} startIcon={<Info />}>
          Info
        </Button>
        {canEdit && (
          <Stack direction="row" spacing={1}>
            <Button startIcon={<Edit />} color="warning" onClick={onEdit}>
              Edit
            </Button>
            <Button startIcon={<Delete />} color="error" onClick={onDelete}>
              Delete
            </Button>
          </Stack>
        )}
      </CardActions>
    </Card>
  );
};

export default HostCard;

