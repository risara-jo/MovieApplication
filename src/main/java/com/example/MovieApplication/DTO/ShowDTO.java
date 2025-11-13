package com.example.MovieApplication.DTO;

import java.time.LocalDateTime;

public class ShowDTO {

    private LocalDateTime showTime;
    private Double price;
    private Long movieId;
    private Long theaterId;
    private String seatPricing;

    public ShowDTO() {
    }

    public LocalDateTime getShowTime() {
        return this.showTime;
    }

    public Double getPrice() {
        return this.price;
    }

    public Long getMovieId() {
        return this.movieId;
    }

    public Long getTheaterId() {
        return this.theaterId;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
    
    public String getSeatPricing() {
        return this.seatPricing;
    }

    public void setSeatPricing(String seatPricing) {
        this.seatPricing = seatPricing;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ShowDTO)) return false;
        final ShowDTO other = (ShowDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$showTime = this.getShowTime();
        final Object other$showTime = other.getShowTime();
        if (this$showTime == null ? other$showTime != null : !this$showTime.equals(other$showTime)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$movieId = this.getMovieId();
        final Object other$movieId = other.getMovieId();
        if (this$movieId == null ? other$movieId != null : !this$movieId.equals(other$movieId)) return false;
        final Object this$theaterId = this.getTheaterId();
        final Object other$theaterId = other.getTheaterId();
        if (this$theaterId == null ? other$theaterId != null : !this$theaterId.equals(other$theaterId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ShowDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $showTime = this.getShowTime();
        result = result * PRIME + ($showTime == null ? 43 : $showTime.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $movieId = this.getMovieId();
        result = result * PRIME + ($movieId == null ? 43 : $movieId.hashCode());
        final Object $theaterId = this.getTheaterId();
        result = result * PRIME + ($theaterId == null ? 43 : $theaterId.hashCode());
        return result;
    }

    public String toString() {
        return "ShowDTO(showTime=" + this.getShowTime() + ", price=" + this.getPrice() + ", movieId=" + this.getMovieId() + ", theaterId=" + this.getTheaterId() + ")";
    }
}
