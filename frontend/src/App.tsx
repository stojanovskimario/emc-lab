import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import AppLayout from './components/layout/AppLayout';
import ProtectedRoute from './components/common/ProtectedRoute';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import AccommodationsPage from './pages/AccommodationsPage';
import AccommodationDetailsPage from './pages/AccommodationDetailsPage';
import HostsPage from './pages/HostsPage';
import HostDetailsPage from './pages/HostDetailsPage';
import CountriesPage from './pages/CountriesPage';
import CountryDetailsPage from './pages/CountryDetailsPage';
import UsersPage from './pages/UsersPage';
import UserDetailsPage from './pages/UserDetailsPage';
import ReservationsPage from './pages/ReservationsPage';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AppLayout />}>
          <Route index element={<HomePage />} />
          <Route path="login" element={<LoginPage />} />
          <Route path="register" element={<RegisterPage />} />

          <Route element={<ProtectedRoute />}>
            <Route path="accommodations" element={<AccommodationsPage />} />
            <Route path="accommodations/:id" element={<AccommodationDetailsPage />} />
            <Route path="hosts" element={<HostsPage />} />
            <Route path="hosts/:id" element={<HostDetailsPage />} />
            <Route path="countries" element={<CountriesPage />} />
            <Route path="countries/:id" element={<CountryDetailsPage />} />
            <Route path="users" element={<UsersPage />} />
            <Route path="users/:id" element={<UserDetailsPage />} />
            <Route path="reservations" element={<ReservationsPage />} />
          </Route>
          <Route path="*" element={<Navigate to="/" replace />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
