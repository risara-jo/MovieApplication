package com.example.MovieApplication.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    private BookingStatus bookingStatus;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "booking_seat_numbers")
    private List<String> seatNumbers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    public Booking() {
    }


    public Long getId() {
        return this.id;
    }

    public Integer getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public LocalDateTime getBookingTime() {
        return this.bookingTime;
    }

    public Double getPrice() {
        return this.price;
    }

    public BookingStatus getBookingStatus() {
        return this.bookingStatus;
    }

    public List<String> getSeatNumbers() {
        return this.seatNumbers;
    }

    public User getUser() {
        return this.user;
    }

    public Show getShow() {
        return this.show;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Booking)) return false;
        final Booking other = (Booking) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$numberOfSeats = this.getNumberOfSeats();
        final Object other$numberOfSeats = other.getNumberOfSeats();
        if (this$numberOfSeats == null ? other$numberOfSeats != null : !this$numberOfSeats.equals(other$numberOfSeats))
            return false;
        final Object this$bookingTime = this.getBookingTime();
        final Object other$bookingTime = other.getBookingTime();
        if (this$bookingTime == null ? other$bookingTime != null : !this$bookingTime.equals(other$bookingTime))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$bookingStatus = this.getBookingStatus();
        final Object other$bookingStatus = other.getBookingStatus();
        if (this$bookingStatus == null ? other$bookingStatus != null : !this$bookingStatus.equals(other$bookingStatus))
            return false;
        final Object this$seatNumbers = this.getSeatNumbers();
        final Object other$seatNumbers = other.getSeatNumbers();
        if (this$seatNumbers == null ? other$seatNumbers != null : !this$seatNumbers.equals(other$seatNumbers))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$show = this.getShow();
        final Object other$show = other.getShow();
        if (this$show == null ? other$show != null : !this$show.equals(other$show)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Booking;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $numberOfSeats = this.getNumberOfSeats();
        result = result * PRIME + ($numberOfSeats == null ? 43 : $numberOfSeats.hashCode());
        final Object $bookingTime = this.getBookingTime();
        result = result * PRIME + ($bookingTime == null ? 43 : $bookingTime.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $bookingStatus = this.getBookingStatus();
        result = result * PRIME + ($bookingStatus == null ? 43 : $bookingStatus.hashCode());
        final Object $seatNumbers = this.getSeatNumbers();
        result = result * PRIME + ($seatNumbers == null ? 43 : $seatNumbers.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $show = this.getShow();
        result = result * PRIME + ($show == null ? 43 : $show.hashCode());
        return result;
    }

    public String toString() {
        return "Booking(id=" + this.getId() + ", numberOfSeats=" + this.getNumberOfSeats() + ", bookingTime=" + this.getBookingTime() + ", price=" + this.getPrice() + ", bookingStatus=" + this.getBookingStatus() + ", seatNumbers=" + this.getSeatNumbers() + ", user=" + this.getUser() + ", show=" + this.getShow() + ")";
    }
}
