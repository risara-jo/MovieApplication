package com.example.MovieApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie_show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime showTime;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Booking> bookings;

    public Show() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getShowTime() {
        return this.showTime;
    }

    public Double getPrice() {
        return this.price;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Theater getTheater() {
        return this.theater;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Show)) return false;
        final Show other = (Show) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$showTime = this.getShowTime();
        final Object other$showTime = other.getShowTime();
        if (this$showTime == null ? other$showTime != null : !this$showTime.equals(other$showTime)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$movie = this.getMovie();
        final Object other$movie = other.getMovie();
        if (this$movie == null ? other$movie != null : !this$movie.equals(other$movie)) return false;
        final Object this$theater = this.getTheater();
        final Object other$theater = other.getTheater();
        if (this$theater == null ? other$theater != null : !this$theater.equals(other$theater)) return false;
        final Object this$bookings = this.getBookings();
        final Object other$bookings = other.getBookings();
        if (this$bookings == null ? other$bookings != null : !this$bookings.equals(other$bookings)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Show;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $showTime = this.getShowTime();
        result = result * PRIME + ($showTime == null ? 43 : $showTime.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $movie = this.getMovie();
        result = result * PRIME + ($movie == null ? 43 : $movie.hashCode());
        final Object $theater = this.getTheater();
        result = result * PRIME + ($theater == null ? 43 : $theater.hashCode());
        final Object $bookings = this.getBookings();
        result = result * PRIME + ($bookings == null ? 43 : $bookings.hashCode());
        return result;
    }

    public String toString() {
        return "Show(id=" + this.getId() + ", showTime=" + this.getShowTime() + ", price=" + this.getPrice() + ", movie=" + this.getMovie() + ", theater=" + this.getTheater() + ", bookings=" + this.getBookings() + ")";
    }
}
