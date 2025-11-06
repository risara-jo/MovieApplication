import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  Container,
  Typography,
  Box,
  Grid,
  TextField,
  MenuItem,
  CircularProgress,
} from '@mui/material';
import { movieApi } from '@/api/movieApi';
import type { Movie } from '@/types/movie.types';
import { MovieCard } from '@/components/Movie/MovieCard';
import toast from 'react-hot-toast';

export const Home = () => {
  const navigate = useNavigate();
  const [movies, setMovies] = useState<Movie[]>([]);
  const [filteredMovies, setFilteredMovies] = useState<Movie[]>([]);
  const [loading, setLoading] = useState(true);
  const [genreFilter, setGenreFilter] = useState('');
  const [languageFilter, setLanguageFilter] = useState('');

  useEffect(() => {
    fetchMovies();
  }, []);

  useEffect(() => {
    filterMovies();
  }, [genreFilter, languageFilter, movies]);

  const fetchMovies = async () => {
    try {
      const data = await movieApi.getAllMovies();
      setMovies(data);
      setFilteredMovies(data);
    } catch (error) {
      toast.error('Failed to fetch movies');
    } finally {
      setLoading(false);
    }
  };

  const filterMovies = () => {
    let filtered = [...movies];

    if (genreFilter) {
      filtered = filtered.filter((movie) => movie.genre === genreFilter);
    }

    if (languageFilter) {
      filtered = filtered.filter((movie) => movie.language === languageFilter);
    }

    setFilteredMovies(filtered);
  };

  const genres = [...new Set(movies.map((m) => m.genre))];
  const languages = [...new Set(movies.map((m) => m.language))];

  if (loading) {
    return (
      <Box display="flex" justifyContent="center" alignItems="center" minHeight="80vh">
        <CircularProgress />
      </Box>
    );
  }

  return (
    <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
      <Typography variant="h3" component="h1" gutterBottom>
        Now Showing
      </Typography>

      <Box sx={{ mb: 4, display: 'flex', gap: 2 }}>
        <TextField
          select
          label="Genre"
          value={genreFilter}
          onChange={(e) => setGenreFilter(e.target.value)}
          sx={{ minWidth: 200 }}
        >
          <MenuItem value="">All Genres</MenuItem>
          {genres.map((genre) => (
            <MenuItem key={genre} value={genre}>
              {genre}
            </MenuItem>
          ))}
        </TextField>

        <TextField
          select
          label="Language"
          value={languageFilter}
          onChange={(e) => setLanguageFilter(e.target.value)}
          sx={{ minWidth: 200 }}
        >
          <MenuItem value="">All Languages</MenuItem>
          {languages.map((language) => (
            <MenuItem key={language} value={language}>
              {language}
            </MenuItem>
          ))}
        </TextField>
      </Box>

      <Grid container spacing={3}>
        {filteredMovies.map((movie) => (
          <Grid size={{ xs: 12, sm: 6, md: 4 }} key={movie.id}>
            <MovieCard
              movie={movie}
              onBook={() => navigate(`/shows?movieId=${movie.id}`)}
            />
          </Grid>
        ))}
      </Grid>

      {filteredMovies.length === 0 && (
        <Box textAlign="center" mt={4}>
          <Typography variant="h6" color="text.secondary">
            No movies found
          </Typography>
        </Box>
      )}
    </Container>
  );
};
