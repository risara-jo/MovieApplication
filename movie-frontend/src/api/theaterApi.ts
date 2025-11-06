import axiosInstance from './axiosConfig';
import type { Theater, TheaterDTO } from '@/types/theater.types';

export const theaterApi = {
  // Get theaters by location
  getTheatersByLocation: async (location: string): Promise<Theater[]> => {
    const response = await axiosInstance.get('/theater/gettheaterbylocation', {
      params: { location },
    });
    return response.data;
  },

  // Add theater (admin only)
  addTheater: async (data: TheaterDTO): Promise<Theater> => {
    const response = await axiosInstance.post('/theater/addtheater', data);
    return response.data;
  },

  // Update theater (admin only)
  updateTheater: async (id: number, data: TheaterDTO): Promise<Theater> => {
    const response = await axiosInstance.put(`/theater/updatetheater/${id}`, data);
    return response.data;
  },

  // Delete theater (admin only)
  deleteTheater: async (id: number): Promise<void> => {
    await axiosInstance.delete(`/theater/deletetheater/${id}`);
  },
};
