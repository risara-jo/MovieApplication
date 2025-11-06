import axiosInstance from './axiosConfig';
import type { Booking, BookingDTO } from '@/types/booking.types';

export const bookingApi = {
  // Create booking
  createBooking: async (data: BookingDTO): Promise<Booking> => {
    const response = await axiosInstance.post('/booking/createbooking', data);
    return response.data;
  },

  // Get user bookings
  getUserBookings: async (userId: number): Promise<Booking[]> => {
    const response = await axiosInstance.get(`/booking/getuserbookings/${userId}`);
    return response.data;
  },

  // Get show bookings
  getShowBookings: async (showId: number): Promise<Booking[]> => {
    const response = await axiosInstance.get(`/booking/getshowbookings/${showId}`);
    return response.data;
  },

  // Confirm booking
  confirmBooking: async (id: number): Promise<Booking> => {
    const response = await axiosInstance.put(`/booking/${id}/confirm`);
    return response.data;
  },

  // Cancel booking
  cancelBooking: async (id: number): Promise<Booking> => {
    const response = await axiosInstance.put(`/booking/${id}/cancel`);
    return response.data;
  },
};
