import { useEffect, useState } from 'react';
import {
  Container,
  Typography,
  Box,
  Grid,
  CircularProgress,
} from '@mui/material';
import { bookingApi } from '@/api/bookingApi';
import type { Booking } from '@/types/booking.types';
import { BookingCard } from '@/components/Booking/BookingCard';
import { useAuth } from '@/hooks/useAuth';
import toast from 'react-hot-toast';

export const MyBookings = () => {
  const { user } = useAuth();
  const [bookings, setBookings] = useState<Booking[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (user) {
      fetchBookings();
    }
  }, [user]);

  const fetchBookings = async () => {
    try {
      if (!user) return;
      const data = await bookingApi.getUserBookings(user.id);
      setBookings(data);
    } catch (error) {
      toast.error('Failed to fetch bookings');
    } finally {
      setLoading(false);
    }
  };

  const handleConfirm = async (id: number) => {
    try {
      await bookingApi.confirmBooking(id);
      toast.success('Booking confirmed!');
      fetchBookings();
    } catch (error) {
      toast.error('Failed to confirm booking');
    }
  };

  const handleCancel = async (id: number) => {
    try {
      await bookingApi.cancelBooking(id);
      toast.success('Booking cancelled');
      fetchBookings();
    } catch (error) {
      toast.error('Failed to cancel booking');
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
      <Typography variant="h4" component="h1" gutterBottom>
        My Bookings
      </Typography>

      {bookings.length === 0 ? (
        <Box textAlign="center" mt={4}>
          <Typography variant="h6" color="text.secondary">
            No bookings found
          </Typography>
        </Box>
      ) : (
        <Grid container spacing={3}>
          {bookings.map((booking) => (
            <Grid size={{ xs: 12 }} key={booking.id}>
              <BookingCard
                booking={booking}
                onConfirm={handleConfirm}
                onCancel={handleCancel}
              />
            </Grid>
          ))}
        </Grid>
      )}
    </Container>
  );
};
