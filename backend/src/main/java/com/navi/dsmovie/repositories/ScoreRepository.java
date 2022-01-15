package com.navi.dsmovie.repositories;

import com.navi.dsmovie.entities.Score;
import com.navi.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
