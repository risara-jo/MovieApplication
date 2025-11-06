import axiosInstance from './axiosConfig';
import type { Movie, MovieDTO } from '@/types/movie.types';

export const movieApi = {
  // Get all movies
  getAllMovies: async (): Promise<Movie[]> => {
    const response = await axiosInstance.get('/movies/getallmovies');
    return response.data;
  },

  // Get movies by genre
  getMoviesByGenre: async (genre: string): Promise<Movie[]> => {
    const response = await axiosInstance.get('/movies/getmoviesbygenre', {
      params: { genre },
    });
    return response.data;
  },

  // Get movies by language
  getMoviesByLanguage: async (language: string): Promise<Movie[]> => {
    const response = await axiosInstance.get('/movies/getmoviesbylanguage', {
      params: { language },
    });
    return response.data;
  },

  // Get movie by title
  getMovieByTitle: async (title: string): Promise<Movie> => {
    const response = await axiosInstance.get('/movies/getmoviebytitle', {
      params: { title },
    });
    return response.data;
  },

  // Add movie (admin only)
  addMovie: async (data: MovieDTO): Promise<Movie> => {
    const response = await axiosInstance.post('/movies/addmovie', data);
    return response.data;
  },

  // Update movie (admin only)
  updateMovie: async (id: number, data: MovieDTO): Promise<Movie> => {
    const response = await axiosInstance.put(`/movies/updatemovie/${id}`, data);
    return response.data;
  },

  // Delete movie (admin only)
  deleteMovie: async (id: number): Promise<void> => {
    await axiosInstance.delete(`/movies/deletemovie/${id}`);
  },
};
