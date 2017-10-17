package com.capgemini.filmapplicatieopdracht.model;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @Column(name = "movieNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieNumber;
    private String movieName;
    private Boolean watched;


    public Movie() {
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

