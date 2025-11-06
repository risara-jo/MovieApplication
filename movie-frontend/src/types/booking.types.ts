import type { User } from './auth.types';
import type { Show } from './show.types';

export const BookingStatus = {
  PENDING: 'PENDING',
  CONFIRMED: 'CONFIRMED',
  CANCELLED: 'CANCELLED',
} as const;

export type BookingStatusType = typeof BookingStatus[keyof typeof BookingStatus];

export interface Booking {
  id: number;
  numberOfSeats: number;
  bookingTime: string;
  price: number;
  bookingStatus: BookingStatusType;
  seatNumbers: string[];
  user: User;
  show: Show;
}

export interface BookingDTO {
  numberOfSeats: number;
  seatNumbers: string[];
  userId: number;
  showId: number;
}
