export interface Movie {
  id: number;
  name: string;
  description: string;
  genre: string;
  duration: number;
  releaseDate: string;
  language: string;
}

export interface MovieDTO {
  name: string;
  description: string;
  genre: string;
  duration: number;
  releaseDate: string;
  language: string;
}
