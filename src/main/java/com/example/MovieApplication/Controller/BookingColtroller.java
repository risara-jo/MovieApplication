package com.example.MovieApplication.Controller;

import com.example.MovieApplication.DTO.BookingDTO;
import com.example.MovieApplication.Entity.Booking;
import com.example.MovieApplication.Service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingColtroller {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createbooking")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Booking> createBooking(
            @Valid @RequestBody BookingDTO bookingDTO,
            Authentication authentication){
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO, authentication));
    }

    @GetMapping("/my-bookings")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Booking>> getMyBookings(Authentication authentication){
        return ResponseEntity.ok(bookingService.getMyBookings(authentication));
    }

    @GetMapping("/getuserbookings/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getUserBookings(id));
    }

    @GetMapping("/getshowbookings/{id}")
    // No authorization required - users need to see booked seats to avoid booking conflicts
    public ResponseEntity<List<Booking>> getShowBookings(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getShowBookings(id));
    }

    @PutMapping("/{id}/confirm")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Booking> confirmBooking(
            @PathVariable Long id,
            Authentication authentication){
        return ResponseEntity.ok(bookingService.confirmBooking(id, authentication));
    }

    @PutMapping("/{id}/cancel")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Booking> cancelBooking(
            @PathVariable Long id,
            Authentication authentication){
        return ResponseEntity.ok(bookingService.cancelBooking(id, authentication));
    }
}
