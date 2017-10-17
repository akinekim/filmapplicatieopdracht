package com.capgemini.filmapplicatieopdracht.controller;


import com.capgemini.filmapplicatieopdracht.model.Movie;
import com.capgemini.filmapplicatieopdracht.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.capgemini.filmapplicatieopdracht.utils.ErrorMapping.mapErrorFields;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public Iterable<Movie> movieList(){
        return movieRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Movie postMovie(@Valid @RequestBody Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Movie deleteMovie(@RequestBody Movie movie){
        movieRepository.delete(movie);
        return movie;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Movie updateMovie(@Valid @RequestBody Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        return mapErrorFields(ex);
    }
}
