package com.navi.dsmovie.service;

import com.navi.dsmovie.dto.MovieDTO;
import com.navi.dsmovie.entities.Movie;
import com.navi.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional
    public Page<MovieDTO> findAllMovies(Pageable pageable){
        Page<Movie> movies = repository.findAll(pageable);
        Page<MovieDTO> movieList = movies.map(x -> new MovieDTO(x));
        return movieList;
    }

    @Transactional
    public MovieDTO findMovieById(Long id) {
        Movie movie = repository.findById(id).get();
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }
}
