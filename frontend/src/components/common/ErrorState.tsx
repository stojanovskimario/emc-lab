import { Alert, AlertTitle } from '@mui/material';

interface ErrorStateProps {
  message: string;
}

const ErrorState = ({ message }: ErrorStateProps) => (
  <Alert severity="error">
    <AlertTitle>Failed to load data</AlertTitle>
    {message}
  </Alert>
);

export default ErrorState;

