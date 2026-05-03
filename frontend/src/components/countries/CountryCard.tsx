import { Card, CardContent, Stack, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import type { Country } from '../../types/country';

interface CountryCardProps {
  country: Country;
}

const CountryCard = ({ country }: CountryCardProps) => {
  return (
    <Card variant="outlined" sx={{ height: '100%' }} component={Link} to={`/countries/${country.id}`} style={{ textDecoration: 'none' }}>
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
    </Card>
  );
};

export default CountryCard;

