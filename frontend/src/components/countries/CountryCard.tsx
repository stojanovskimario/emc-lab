import { Button, Card, CardActions, CardContent, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Country } from '../../types/country';
import { Delete, Edit, Info } from '@mui/icons-material';

interface CountryCardProps {
  country: Country;
  canEdit?: boolean;
  onEdit?: () => void;
  onDelete?: () => void;
}

const CountryCard = ({ country, canEdit, onEdit, onDelete }: CountryCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }}>
      <CardContent>
        <Stack spacing={1}>
          <Typography variant="h6">{country.name}</Typography>
          <Typography variant="body2" color="text.secondary">
            Country ID: {country.id}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Continent: {country.continent}
          </Typography>
        </Stack>
      </CardContent>
      <CardActions sx={{ justifyContent: 'space-between', px: 2, pb: 2 }}>
        <Button component={Link} to={`/countries/${country.id}`} startIcon={<Info />}>
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

export default CountryCard;

