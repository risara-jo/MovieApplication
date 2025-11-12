package com.example.MovieApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;
    private String theaterLocation;
    private Integer theaterCapacity;
    private String theaterScreenType;
    private Integer numberOfRows;
    private Integer seatsPerRow;
    
    @Column(columnDefinition = "TEXT")
    private String seatLayout; // Stores seat arrangement as comma-separated row data

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Show> show;

    public Theater() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTheaterName() {
        return this.theaterName;
    }

    public String getTheaterLocation() {
        return this.theaterLocation;
    }

    public Integer getTheaterCapacity() {
        return this.theaterCapacity;
    }

    public String getTheaterScreenType() {
        return this.theaterScreenType;
    }

    public List<Show> getShow() {
        return this.show;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }

    public void setTheaterCapacity(Integer theaterCapacity) {
        this.theaterCapacity = theaterCapacity;
    }

    public void setTheaterScreenType(String theaterScreenType) {
        this.theaterScreenType = theaterScreenType;
    }

    public Integer getNumberOfRows() {
        return this.numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public Integer getSeatsPerRow() {
        return this.seatsPerRow;
    }

    public void setSeatsPerRow(Integer seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public String getSeatLayout() {
        return this.seatLayout;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Theater)) return false;
        final Theater other = (Theater) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$theaterName = this.getTheaterName();
        final Object other$theaterName = other.getTheaterName();
        if (this$theaterName == null ? other$theaterName != null : !this$theaterName.equals(other$theaterName))
            return false;
        final Object this$theaterLocation = this.getTheaterLocation();
        final Object other$theaterLocation = other.getTheaterLocation();
        if (this$theaterLocation == null ? other$theaterLocation != null : !this$theaterLocation.equals(other$theaterLocation))
            return false;
        final Object this$theaterCapacity = this.getTheaterCapacity();
        final Object other$theaterCapacity = other.getTheaterCapacity();
        if (this$theaterCapacity == null ? other$theaterCapacity != null : !this$theaterCapacity.equals(other$theaterCapacity))
            return false;
        final Object this$theaterScreenType = this.getTheaterScreenType();
        final Object other$theaterScreenType = other.getTheaterScreenType();
        if (this$theaterScreenType == null ? other$theaterScreenType != null : !this$theaterScreenType.equals(other$theaterScreenType))
            return false;
        final Object this$show = this.getShow();
        final Object other$show = other.getShow();
        if (this$show == null ? other$show != null : !this$show.equals(other$show)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Theater;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $theaterName = this.getTheaterName();
        result = result * PRIME + ($theaterName == null ? 43 : $theaterName.hashCode());
        final Object $theaterLocation = this.getTheaterLocation();
        result = result * PRIME + ($theaterLocation == null ? 43 : $theaterLocation.hashCode());
        final Object $theaterCapacity = this.getTheaterCapacity();
        result = result * PRIME + ($theaterCapacity == null ? 43 : $theaterCapacity.hashCode());
        final Object $theaterScreenType = this.getTheaterScreenType();
        result = result * PRIME + ($theaterScreenType == null ? 43 : $theaterScreenType.hashCode());
        final Object $show = this.getShow();
        result = result * PRIME + ($show == null ? 43 : $show.hashCode());
        return result;
    }

    public String toString() {
        return "Theater(id=" + this.getId() + ", theaterName=" + this.getTheaterName() + ", theaterLocation=" + this.getTheaterLocation() + ", theaterCapacity=" + this.getTheaterCapacity() + ", theaterScreenType=" + this.getTheaterScreenType() + ", show=" + this.getShow() + ")";
    }
}
