import type { Category, Status } from './accomodation';

export interface CreateAccommodationRequest {
  name: string;
  category: Category;
  status: Status;
  numRooms: number;
  hostId: number;
  rented: boolean;
}

export interface CreateHostRequest {
  name: string;
  surname: string;
  countryId: number;
}

export interface CreateCountryRequest {
  name: string;
  continent: string;
}

export interface LoginUserRequest {
  username: string;
  password: string;
}

export interface RegisterUserRequest {
  name: string;
  surname: string;
  email: string;
  username: string;
  password: string;
}

