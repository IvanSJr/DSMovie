package com.navi.dsmovie.dto;

import com.navi.dsmovie.entities.Movie;

public class MovieDTO {

    private Long id;
    private String title;
    private String image;
    private Integer count;
    private Double score;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String image, Integer count, Double score) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.count = count;
        this.score = score;
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.image = movie.getImage();
        this.count = movie.getCount();
        this.score = movie.getScore();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
