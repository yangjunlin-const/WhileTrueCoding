package com.yjl.spring.model;

public class Movie2MovieRecommend {
    private Integer recomId;

    private Integer movieId;

    private String recomMovieIds;

    public Integer getRecomId() {
        return recomId;
    }

    public void setRecomId(Integer recomId) {
        this.recomId = recomId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getRecomMovieIds() {
        return recomMovieIds;
    }

    public void setRecomMovieIds(String recomMovieIds) {
        this.recomMovieIds = recomMovieIds == null ? null : recomMovieIds.trim();
    }
}