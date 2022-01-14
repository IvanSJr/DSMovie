package com.navi.dsmovie.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ScorePK implements Serializable {
    private static final long serialVersionUID = 6352196020370746522L;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ScorePK() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
