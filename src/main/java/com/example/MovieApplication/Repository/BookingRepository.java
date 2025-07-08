package com.example.MovieApplication.Repository;

import com.example.MovieApplication.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);
    List<Booking> findByShowId(Long showId);
}
