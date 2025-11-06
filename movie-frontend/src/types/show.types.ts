import type { Movie } from './movie.types';
import type { Theater } from './theater.types';

export interface Show {
  id: number;
  showTime: string;
  price: number;
  movie: Movie;
  theater: Theater;
}

export interface ShowDTO {
  showTime: string;
  price: number;
  movieId: number;
  theaterId: number;
}
