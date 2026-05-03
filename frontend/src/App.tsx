import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import AppLayout from './components/layout/AppLayout';
import HomePage from './pages/HomePage';
import AccommodationsPage from './pages/AccommodationsPage';
import AccommodationDetailsPage from './pages/AccommodationDetailsPage';
import HostsPage from './pages/HostsPage';
import HostDetailsPage from './pages/HostDetailsPage';
import CountriesPage from './pages/CountriesPage';
import CountryDetailsPage from './pages/CountryDetailsPage';

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AppLayout />}>
          <Route index element={<HomePage />} />
          <Route path="accommodations" element={<AccommodationsPage />} />
          <Route path="accommodations/:id" element={<AccommodationDetailsPage />} />
          <Route path="hosts" element={<HostsPage />} />
          <Route path="hosts/:id" element={<HostDetailsPage />} />
          <Route path="countries" element={<CountriesPage />} />
          <Route path="countries/:id" element={<CountryDetailsPage />} />
          <Route path="*" element={<Navigate to="/" replace />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
