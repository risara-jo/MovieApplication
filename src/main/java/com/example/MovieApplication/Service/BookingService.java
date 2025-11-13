package com.example.MovieApplication.Service;

import com.example.MovieApplication.DTO.BookingDTO;
import com.example.MovieApplication.Entity.Booking;
import com.example.MovieApplication.Entity.BookingStatus;
import com.example.MovieApplication.Entity.Show;
import com.example.MovieApplication.Entity.User;
import com.example.MovieApplication.Repository.BookingRepository;
import com.example.MovieApplication.Repository.ShowRepository;
import com.example.MovieApplication.Repository.UserRepository;
import com.example.MovieApplication.exception.BookingException;
import com.example.MovieApplication.exception.ResourceNotFoundException;
import com.example.MovieApplication.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserRepository userRepository;

    public Booking createBooking(BookingDTO bookingDTO, Authentication authentication){

        // Get authenticated user instead of trusting DTO userId
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(()-> new ResourceNotFoundException("Show not found."));

        if(!isSeatsAvailable(show.getId(), bookingDTO.getNumberOfSeats())){
            throw new BookingException("Not enough seats are available.");
        }

        if(bookingDTO.getSeatNumbers().size() != bookingDTO.getNumberOfSeats()){
            throw new BookingException("seat numbers and number of seats must be equal");
        }
        validateDuplicateSeat(show.getId(), bookingDTO.getSeatNumbers());

        // Calculate and validate the price
        Double calculatedPrice = calculatePriceForSeats(show, bookingDTO.getSeatNumbers());
        
        // If DTO provides a price, validate it matches our calculation (prevent price manipulation)
        if (bookingDTO.getPrice() != null) {
            // Allow small floating point differences (within 1 cent)
            if (Math.abs(bookingDTO.getPrice() - calculatedPrice) > 0.01) {
                throw new BookingException("Price mismatch. Expected: " + calculatedPrice + ", Received: " + bookingDTO.getPrice());
            }
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
        booking.setSeatNumbers(bookingDTO.getSeatNumbers());
        booking.setPrice(calculatedPrice);  // Use calculated price for security
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(Authentication authentication){
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        return bookingRepository.findByUserId(user.getId());
    }

    public List<Booking> getUserBookings(Long userid){

        return bookingRepository.findByUserId(userid);
    }

    public List<Booking> getShowBookings(Long showId){

        return bookingRepository.findByShowId(showId);
    }

    public Booking confirmBooking(Long bookingid, Authentication authentication){
        Booking booking = bookingRepository.findById(bookingid)
                .orElseThrow(()->new ResourceNotFoundException("Booking not found."));

        // Verify ownership
        String username = authentication.getName();
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean isOwner = booking.getUser().getId().equals(currentUser.getId());
        boolean isAdmin = currentUser.getRoles().contains("ROLE_ADMIN");

        if (!isOwner && !isAdmin) {
            throw new UnauthorizedException("You don't have permission to confirm this booking");
        }

        if(booking.getBookingStatus() != BookingStatus.PENDING){
            throw new BookingException("Booking is not in PENDING State.");
        }
        //Payment API's
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }

    public Booking cancelBooking(Long bookingId, Authentication authentication){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()->new ResourceNotFoundException("Booking not found."));

        // Verify ownership
        String username = authentication.getName();
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean isOwner = booking.getUser().getId().equals(currentUser.getId());
        boolean isAdmin = currentUser.getRoles().contains("ROLE_ADMIN");

        if (!isOwner && !isAdmin) {
            throw new UnauthorizedException("You don't have permission to cancel this booking");
        }

        valitateCancellation(booking);

        booking.setBookingStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

//    public List<Booking> getBookingsByStatus(BookingStatus status ) {
//        return bookings.stream()
//                .filter(booking -> booking.getStatus() == status)
//                .collect(Collectors.toList());
//    }


    public void valitateCancellation(Booking booking){
        LocalDateTime showTime = booking.getShow().getShowTime();
        LocalDateTime deadlineTime =  showTime.minusHours(2);

        if(LocalDateTime.now().isAfter(deadlineTime)){
            throw new BookingException("Cannot cancel the booking");
        }
        if (booking.getBookingStatus() == BookingStatus.CANCELLED){
            throw new BookingException("Booking already been cancelled.");
        }
    }

    public boolean isSeatsAvailable(Long showid, Integer numberOfSeats){
        Show show = showRepository.findById(showid)
                .orElseThrow(()-> new ResourceNotFoundException("Show not found."));

        int bookedSeats = show.getBookings().stream()
                .filter(booking -> booking.getBookingStatus() != BookingStatus.CANCELLED)
                .mapToInt(Booking::getNumberOfSeats)
                .sum();
        return (show.getTheater().getTheaterCapacity() - bookedSeats) >= numberOfSeats;
    }

    public void validateDuplicateSeat(Long showId, List<String> seatNumbers){

        Show show = showRepository.findById(showId)
                .orElseThrow(()-> new ResourceNotFoundException("Show not found."));

        Set<String> occupiedSeats = show.getBookings().stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CANCELLED)
                .flatMap(b -> b.getSeatNumbers().stream())
                .collect(Collectors.toSet());

        List<String> duplicateSeats = seatNumbers.stream()
                .filter(occupiedSeats::contains)
                .collect(Collectors.toList());

        if(!duplicateSeats.isEmpty()){
            throw new BookingException("Seats are already booked!");
        }
    }

    public Double calculateTotalAmount(Double price, Integer numberOfSeats){
        return price * numberOfSeats;
    }

    /**
     * Calculate the total price for specific seats, accounting for custom seat pricing
     * @param show The show containing default price and optional custom pricing
     * @param seatNumbers List of seat numbers being booked (e.g., ["A5", "A6", "A7"])
     * @return Total price for all seats
     */
    public Double calculatePriceForSeats(Show show, List<String> seatNumbers) {
        Double totalPrice = 0.0;
        Double defaultPrice = show.getPrice();
        
        // Parse custom seat pricing if available
        java.util.Map<String, Double> customPricing = new java.util.HashMap<>();
        if (show.getSeatPricing() != null && !show.getSeatPricing().isEmpty()) {
            try {
                // Parse JSON string like {"A5":100.00,"A6":100.00}
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                customPricing = mapper.readValue(show.getSeatPricing(), 
                    new com.fasterxml.jackson.core.type.TypeReference<java.util.Map<String, Double>>() {});
            } catch (Exception e) {
                // If parsing fails, log and use default pricing for all seats
                System.err.println("Failed to parse seat pricing JSON: " + e.getMessage());
            }
        }
        
        // Calculate price for each seat
        for (String seatNumber : seatNumbers) {
            Double seatPrice = customPricing.getOrDefault(seatNumber, defaultPrice);
            totalPrice += seatPrice;
        }
        
        return totalPrice;
    }

}
