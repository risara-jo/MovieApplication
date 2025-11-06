import {
  Card,
  CardContent,
  CardActions,
  Typography,
  Button,
  Box,
  Chip,
} from '@mui/material';
import type { Movie } from '@/types/movie.types';
import { format } from 'date-fns';

interface MovieCardProps {
  movie: Movie;
  onBook?: () => void;
  onEdit?: () => void;
  onDelete?: () => void;
  isAdmin?: boolean;
}

export const MovieCard = ({ movie, onBook, onEdit, onDelete, isAdmin }: MovieCardProps) => {
  return (
    <Card>
      <CardContent>
        <Typography variant="h5" component="h2" gutterBottom>
          {movie.name}
        </Typography>
        <Box mb={2} display="flex" gap={1}>
          <Chip label={movie.genre} size="small" color="primary" />
          <Chip label={movie.language} size="small" variant="outlined" />
        </Box>
        <Typography variant="body2" color="text.secondary" paragraph>
          {movie.description}
        </Typography>
        <Typography variant="body2">
          <strong>Duration:</strong> {movie.duration} minutes
        </Typography>
        <Typography variant="body2">
          <strong>Release Date:</strong> {format(new Date(movie.releaseDate), 'MMM dd, yyyy')}
        </Typography>
      </CardContent>
      <CardActions>
        {isAdmin ? (
          <>
            <Button size="small" onClick={onEdit}>
              Edit
            </Button>
            <Button size="small" color="error" onClick={onDelete}>
              Delete
            </Button>
          </>
        ) : (
          <Button size="small" variant="contained" onClick={onBook}>
            Book Tickets
          </Button>
        )}
      </CardActions>
    </Card>
  );
};
