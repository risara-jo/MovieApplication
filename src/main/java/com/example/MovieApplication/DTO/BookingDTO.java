package com.example.MovieApplication.DTO;

import com.example.MovieApplication.Entity.BookingStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDTO {
    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Must book at least 1 seat")
    @Max(value = 10, message = "Cannot book more than 10 seats at once")
    private Integer numberOfSeats;

    private LocalDateTime bookingTime;
    private Double price;
    private BookingStatus bookingStatus;

    @NotEmpty(message = "Seat numbers are required")
    @Size(min = 1, max = 10, message = "Must specify 1-10 seat numbers")
    private List<String> seatNumbers;

    private Long userId;

    @NotNull(message = "Show ID is required")
    private Long showId;

    public BookingDTO() {
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

    public Long getUserId() {
        return this.userId;
    }

    public Long getShowId() {
        return this.showId;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BookingDTO)) return false;
        final BookingDTO other = (BookingDTO) o;
        if (!other.canEqual((Object) this)) return false;
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
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$showId = this.getShowId();
        final Object other$showId = other.getShowId();
        if (this$showId == null ? other$showId != null : !this$showId.equals(other$showId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BookingDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
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
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $showId = this.getShowId();
        result = result * PRIME + ($showId == null ? 43 : $showId.hashCode());
        return result;
    }

    public String toString() {
        return "BookingDTO(numberOfSeats=" + this.getNumberOfSeats() + ", bookingTime=" + this.getBookingTime() + ", price=" + this.getPrice() + ", bookingStatus=" + this.getBookingStatus() + ", seatNumbers=" + this.getSeatNumbers() + ", userId=" + this.getUserId() + ", showId=" + this.getShowId() + ")";
    }
}
