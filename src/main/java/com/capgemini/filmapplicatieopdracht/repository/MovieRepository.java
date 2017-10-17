package com.capgemini.filmapplicatieopdracht.repository;

import com.capgemini.filmapplicatieopdracht.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
}
