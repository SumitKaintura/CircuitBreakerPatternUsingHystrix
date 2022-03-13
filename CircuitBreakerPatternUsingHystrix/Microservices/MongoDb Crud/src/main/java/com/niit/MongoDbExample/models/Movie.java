package com.niit.MongoDbExample.models;

public class Movie {

    private String movieId;
    private String movieName;
    private String genre;
    private String yearOfRelease;
    private String rating;

    public Movie() {}
    public Movie(String movieId, String movieName, String genre, String yearOfRelease, String rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getRating() {
        return rating;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
