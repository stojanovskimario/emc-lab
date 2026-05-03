export type Category = 'APARTMENT' | 'HOUSE' | 'MOTEL' | 'HOTEL' | 'FLAT' | 'ROOM';
export type Status = 'GOOD' | 'BAD' | 'NEW' | 'RENOVATED';

export interface Accomodation {
  id: number;
  name: string;
  category: Category;
  status: Status;
  numRooms: number;
  hostId: number;
  rented: boolean;
}

