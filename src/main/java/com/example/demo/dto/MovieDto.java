package com.example.demo.dto;

public class MovieDto {

  private String id;

  private String title;

  private String genre;

  private String director;

  private int releaseYear;

  private int rating;

  private boolean isPopular;

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

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public boolean isPopular() {
    return isPopular;
  }

  public void setPopular(boolean isPopular) {
    this.isPopular = isPopular;
  }



}
