package com.example.MovieApplication.DTO;

import java.time.LocalDate;

public class MovieDTO {

    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;

    public MovieDTO() {
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MovieDTO)) return false;
        final MovieDTO other = (MovieDTO) o;
        if (!other.canEqual((Object) this)) return false;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MovieDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
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
        return result;
    }

    public String toString() {
        return "MovieDTO(name=" + this.getName() + ", description=" + this.getDescription() + ", genre=" + this.getGenre() + ", duration=" + this.getDuration() + ", releaseDate=" + this.getReleaseDate() + ", language=" + this.getLanguage() + ")";
    }
}
