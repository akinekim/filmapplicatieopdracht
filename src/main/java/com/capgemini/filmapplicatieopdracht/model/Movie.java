package com.capgemini.filmapplicatieopdracht.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieNumber;
    @Length(max = 25, min = 1, message = "Movie name must be between 1 and 25 characters.")
    private String movieName;
    private boolean watched;

    public Movie() {
    }

    public Movie(String movieName, boolean watched) {
        this.movieName = movieName;
        this.watched = watched;
    }

    public long getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(long movieNumber) {
        this.movieNumber = movieNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}