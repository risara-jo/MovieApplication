import axiosInstance from './axiosConfig';
import type { Show, ShowDTO } from '@/types/show.types';

export const showApi = {
  // Get all shows
  getAllShows: async (): Promise<Show[]> => {
    const response = await axiosInstance.get('/show/getallshows');
    return response.data;
  },

  // Get shows by movie
  getShowsByMovie: async (movieId: number): Promise<Show[]> => {
    const response = await axiosInstance.get(`/show/getshowsbymovie/${movieId}`);
    return response.data;
  },

  // Get shows by theater
  getShowsByTheater: async (theaterId: number): Promise<Show[]> => {
    const response = await axiosInstance.get(`/show/getshowsbytheater/${theaterId}`);
    return response.data;
  },

  // Create show
  createShow: async (data: ShowDTO): Promise<Show> => {
    const response = await axiosInstance.post('/show/createshow', data);
    return response.data;
  },

  // Update show
  updateShow: async (id: number, data: ShowDTO): Promise<Show> => {
    const response = await axiosInstance.put(`/show/updateshow/${id}`, data);
    return response.data;
  },

  // Delete show
  deleteShow: async (id: number): Promise<void> => {
    await axiosInstance.delete(`/show/deleteshow/${id}`);
  },
};
