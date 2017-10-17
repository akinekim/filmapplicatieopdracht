package com.capgemini.filmapplicatieopdracht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieNumber;
    private String movieName;
    private Boolean watched;


    public Movie() {
    }

    public Movie(String movieName, Boolean watched) {
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

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }
}

