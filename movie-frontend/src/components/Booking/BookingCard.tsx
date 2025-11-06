import {
  Card,
  CardContent,
  Typography,
  Box,
  Chip,
  Button,
} from '@mui/material';
import type { Booking, BookingStatusType } from '@/types/booking.types';
import { BookingStatus } from '@/types/booking.types';
import { format } from 'date-fns';

interface BookingCardProps {
  booking: Booking;
  onConfirm?: (id: number) => void;
  onCancel?: (id: number) => void;
}

export const BookingCard = ({ booking, onConfirm, onCancel }: BookingCardProps) => {
  const getStatusColor = (status: BookingStatusType) => {
    switch (status) {
      case BookingStatus.CONFIRMED:
        return 'success';
      case BookingStatus.PENDING:
        return 'warning';
      case BookingStatus.CANCELLED:
        return 'error';
      default:
        return 'default';
    }
  };

  return (
    <Card>
      <CardContent>
        <Box display="flex" justifyContent="space-between" alignItems="start" mb={2}>
          <Box>
            <Typography variant="h6">{booking.show.movie.name}</Typography>
            <Typography variant="body2" color="text.secondary">
              {booking.show.theater.theaterName}
            </Typography>
          </Box>
          <Chip
            label={booking.bookingStatus}
            color={getStatusColor(booking.bookingStatus)}
            size="small"
          />
        </Box>

        <Typography variant="body2">
          <strong>Show Time:</strong> {format(new Date(booking.show.showTime), 'PPp')}
        </Typography>
        <Typography variant="body2">
          <strong>Seats:</strong> {booking.seatNumbers.join(', ')}
        </Typography>
        <Typography variant="body2">
          <strong>Number of Seats:</strong> {booking.numberOfSeats}
        </Typography>
        <Typography variant="body2">
          <strong>Total Price:</strong> ${booking.price.toFixed(2)}
        </Typography>
        <Typography variant="body2">
          <strong>Booking Time:</strong> {format(new Date(booking.bookingTime), 'PPp')}
        </Typography>

        {booking.bookingStatus === BookingStatus.PENDING && (
          <Box mt={2} display="flex" gap={2}>
            <Button
              variant="contained"
              color="success"
              size="small"
              onClick={() => onConfirm?.(booking.id)}
            >
              Confirm
            </Button>
            <Button
              variant="outlined"
              color="error"
              size="small"
              onClick={() => onCancel?.(booking.id)}
            >
              Cancel
            </Button>
          </Box>
        )}
      </CardContent>
    </Card>
  );
};
