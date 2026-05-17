import { Navigate, Outlet, useLocation } from 'react-router-dom';
import LoadingState from './LoadingState';
import { useCurrentUser } from '../../hooks/useCurrentUser';
import type { UserRole } from '../../types/user';

interface ProtectedRouteProps {
  allowedRoles?: UserRole[];
}

const ProtectedRoute = ({ allowedRoles }: ProtectedRouteProps) => {
  const location = useLocation();
  const token = localStorage.getItem('jwtToken');
  const { item: currentUser, loading, error } = useCurrentUser(Boolean(token));

  if (!token) {
    return <Navigate to="/login" replace state={{ from: location }} />;
  }

  if (loading) {
    return <LoadingState />;
  }

  if (error || !currentUser) {
    localStorage.removeItem('jwtToken');
    return <Navigate to="/login" replace state={{ from: location }} />;
  }

  if (allowedRoles && !allowedRoles.includes(currentUser.role)) {
    return <Navigate to="/" replace />;
  }

  return <Outlet />;
};

export default ProtectedRoute;

