package com.capgemini.filmapplicatieopdracht.controller;


import com.capgemini.filmapplicatieopdracht.model.Movie;
import com.capgemini.filmapplicatieopdracht.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/api/movie" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Movie> movieList() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/api/movie", method = RequestMethod.POST)
    public Movie process(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @RequestMapping(value = "/api/movie", method = RequestMethod.DELETE)
    public Movie deleteMovie(@RequestBody Movie movie) {
        movieRepository.delete(movie);
        return movie;
    }

    @RequestMapping(value = "/api/movie", method = RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }
}
