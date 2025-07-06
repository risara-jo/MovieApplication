package com.example.MovieApplication.Repository;

import com.example.MovieApplication.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Long> {
}
