package com.example.MovieApplication.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Show> show;

    public Movie() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGenre() {
        return this.genre;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<Show> getShow() {
        return this.show;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Movie)) return false;
        final Movie other = (Movie) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$genre = this.getGenre();
        final Object other$genre = other.getGenre();
        if (this$genre == null ? other$genre != null : !this$genre.equals(other$genre)) return false;
        final Object this$duration = this.getDuration();
        final Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) return false;
        final Object this$releaseDate = this.getReleaseDate();
        final Object other$releaseDate = other.getReleaseDate();
        if (this$releaseDate == null ? other$releaseDate != null : !this$releaseDate.equals(other$releaseDate))
            return false;
        final Object this$language = this.getLanguage();
        final Object other$language = other.getLanguage();
        if (this$language == null ? other$language != null : !this$language.equals(other$language)) return false;
        final Object this$show = this.getShow();
        final Object other$show = other.getShow();
        if (this$show == null ? other$show != null : !this$show.equals(other$show)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Movie;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $genre = this.getGenre();
        result = result * PRIME + ($genre == null ? 43 : $genre.hashCode());
        final Object $duration = this.getDuration();
        result = result * PRIME + ($duration == null ? 43 : $duration.hashCode());
        final Object $releaseDate = this.getReleaseDate();
        result = result * PRIME + ($releaseDate == null ? 43 : $releaseDate.hashCode());
        final Object $language = this.getLanguage();
        result = result * PRIME + ($language == null ? 43 : $language.hashCode());
        final Object $show = this.getShow();
        result = result * PRIME + ($show == null ? 43 : $show.hashCode());
        return result;
    }

    public String toString() {
        return "Movie(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", genre=" + this.getGenre() + ", duration=" + this.getDuration() + ", releaseDate=" + this.getReleaseDate() + ", language=" + this.getLanguage() + ", show=" + this.getShow() + ")";
    }
}
