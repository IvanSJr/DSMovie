package com.navi.dsmovie.service;

import com.navi.dsmovie.dto.MovieDTO;
import com.navi.dsmovie.dto.ScoreDTO;
import com.navi.dsmovie.entities.Movie;
import com.navi.dsmovie.entities.Score;
import com.navi.dsmovie.entities.User;
import com.navi.dsmovie.repositories.MovieRepository;
import com.navi.dsmovie.repositories.ScoreRepository;
import com.navi.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());
        score = scoreRepository.saveAndFlush(score);

        Double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        Double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.saveAndFlush(movie);
        return new MovieDTO(movie);
    }
}
