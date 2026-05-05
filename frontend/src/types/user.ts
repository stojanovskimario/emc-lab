export type UserRole = 'ROLE_USER' | 'ROLE_ADMINISTRATOR';

export interface User {
  id: number;
  name: string;
  surname: string;
  email: string;
  username: string;
  role: UserRole;
}

