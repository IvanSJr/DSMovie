package com.navi.dsmovie.controllers;

import com.navi.dsmovie.dto.MovieDTO;
import com.navi.dsmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<MovieDTO>> findAllMovies(Pageable pageable){
        Page<MovieDTO> movieDTO = movieService.findAllMovies(pageable);
        return ResponseEntity.ok().body(movieDTO);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable Long id){
        MovieDTO movie = movieService.findMovieById(id);
        return ResponseEntity.ok().body(movie);
    }

}
