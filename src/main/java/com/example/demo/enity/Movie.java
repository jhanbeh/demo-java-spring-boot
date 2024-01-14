package com.example.demo.enity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

  @Id
  private String id;

  private String title;

  private String genre;

  private String director;

  private BigDecimal releaseYear;

  private BigDecimal rating;

  private Boolean isPopular;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public BigDecimal getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(BigDecimal releaseYear) {
    this.releaseYear = releaseYear;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public Boolean getIsPopular() {
    return isPopular;
  }

  public void setIsPopular(Boolean isPopular) {
    this.isPopular = isPopular;
  }

  @Override
  public String toString() {
    return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director
        + ", releaseYear=" + releaseYear + ", rating=" + rating + ", isPopular=" + isPopular + "]";
  }
}
