import { useEffect, useState } from 'react';
import {
  Container,
  Typography,
  Box,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  Grid,
  CircularProgress,
} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import { movieApi } from '@/api/movieApi';
import type { Movie, MovieDTO } from '@/types/movie.types';
import { MovieCard } from '@/components/Movie/MovieCard';
import { MovieForm } from '@/components/Movie/MovieForm';
import toast from 'react-hot-toast';

export const ManageMovies = () => {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [loading, setLoading] = useState(true);
  const [openDialog, setOpenDialog] = useState(false);
  const [editingMovie, setEditingMovie] = useState<Movie | null>(null);

  useEffect(() => {
    fetchMovies();
  }, []);

  const fetchMovies = async () => {
    try {
      const data = await movieApi.getAllMovies();
      setMovies(data);
    } catch (error) {
      toast.error('Failed to fetch movies');
    } finally {
      setLoading(false);
    }
  };

  const handleAdd = () => {
    setEditingMovie(null);
    setOpenDialog(true);
  };

  const handleEdit = (movie: Movie) => {
    setEditingMovie(movie);
    setOpenDialog(true);
  };

  const handleDelete = async (id: number) => {
    if (!window.confirm('Are you sure you want to delete this movie?')) return;

    try {
      await movieApi.deleteMovie(id);
      toast.success('Movie deleted successfully');
      fetchMovies();
    } catch (error) {
      toast.error('Failed to delete movie');
    }
  };

  const handleSubmit = async (data: MovieDTO) => {
    try {
      if (editingMovie) {
        await movieApi.updateMovie(editingMovie.id, data);
        toast.success('Movie updated successfully');
      } else {
        await movieApi.addMovie(data);
        toast.success('Movie added successfully');
      }
      setOpenDialog(false);
      fetchMovies();
    } catch (error) {
      toast.error('Failed to save movie');
    }
  };

  if (loading) {
    return (
      <Box display="flex" justifyContent="center" alignItems="center" minHeight="80vh">
        <CircularProgress />
      </Box>
    );
  }

  return (
    <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
      <Box display="flex" justifyContent="space-between" alignItems="center" mb={4}>
        <Typography variant="h4" component="h1">
          Manage Movies
        </Typography>
        <Button variant="contained" startIcon={<AddIcon />} onClick={handleAdd}>
          Add Movie
        </Button>
      </Box>

      <Grid container spacing={3}>
        {movies.map((movie) => (
          <Grid size={{ xs: 12, sm: 6, md: 4 }} key={movie.id}>
            <MovieCard
              movie={movie}
              onEdit={() => handleEdit(movie)}
              onDelete={() => handleDelete(movie.id)}
              isAdmin
            />
          </Grid>
        ))}
      </Grid>

      <Dialog open={openDialog} onClose={() => setOpenDialog(false)} maxWidth="sm" fullWidth>
        <DialogTitle>{editingMovie ? 'Edit Movie' : 'Add Movie'}</DialogTitle>
        <DialogContent>
          <MovieForm
            movie={editingMovie}
            onSubmit={handleSubmit}
            onCancel={() => setOpenDialog(false)}
          />
        </DialogContent>
      </Dialog>
    </Container>
  );
};
