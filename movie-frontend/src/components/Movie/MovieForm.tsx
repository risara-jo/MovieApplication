import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import { Box, TextField, Button } from '@mui/material';
import type { Movie, MovieDTO } from '@/types/movie.types';

const schema = yup.object({
  name: yup.string().required('Name is required'),
  description: yup.string().required('Description is required'),
  genre: yup.string().required('Genre is required'),
  duration: yup.number().positive().required('Duration is required'),
  releaseDate: yup.string().required('Release date is required'),
  language: yup.string().required('Language is required'),
});

interface MovieFormProps {
  movie: Movie | null;
  onSubmit: (data: MovieDTO) => void;
  onCancel: () => void;
}

export const MovieForm = ({ movie, onSubmit, onCancel }: MovieFormProps) => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<MovieDTO>({
    resolver: yupResolver(schema),
    defaultValues: movie || {},
  });

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Box display="flex" flexDirection="column" gap={2} mt={2}>
        <TextField
          {...register('name')}
          label="Movie Name"
          error={!!errors.name}
          helperText={errors.name?.message}
        />
        <TextField
          {...register('description')}
          label="Description"
          multiline
          rows={3}
          error={!!errors.description}
          helperText={errors.description?.message}
        />
        <TextField
          {...register('genre')}
          label="Genre"
          error={!!errors.genre}
          helperText={errors.genre?.message}
        />
        <TextField
          {...register('duration')}
          label="Duration (minutes)"
          type="number"
          error={!!errors.duration}
          helperText={errors.duration?.message}
        />
        <TextField
          {...register('releaseDate')}
          label="Release Date"
          type="date"
          InputLabelProps={{ shrink: true }}
          error={!!errors.releaseDate}
          helperText={errors.releaseDate?.message}
        />
        <TextField
          {...register('language')}
          label="Language"
          error={!!errors.language}
          helperText={errors.language?.message}
        />
        <Box display="flex" gap={2} justifyContent="flex-end">
          <Button onClick={onCancel}>Cancel</Button>
          <Button type="submit" variant="contained" disabled={isSubmitting}>
            {isSubmitting ? 'Saving...' : 'Save'}
          </Button>
        </Box>
      </Box>
    </form>
  );
};
