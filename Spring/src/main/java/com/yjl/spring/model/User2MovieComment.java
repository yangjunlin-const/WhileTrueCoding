package com.yjl.spring.model;

import java.util.Date;

public class User2MovieComment {
    private Integer movieCommentId;

    private Integer userId;

    private Integer movieId;

    private String movieTitle;

    private String movieValue;

    private String movieComment;

    private Date commentTime;

    public Integer getMovieCommentId() {
        return movieCommentId;
    }

    public void setMovieCommentId(Integer movieCommentId) {
        this.movieCommentId = movieCommentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle == null ? null : movieTitle.trim();
    }

    public String getMovieValue() {
        return movieValue;
    }

    public void setMovieValue(String movieValue) {
        this.movieValue = movieValue == null ? null : movieValue.trim();
    }

    public String getMovieComment() {
        return movieComment;
    }

    public void setMovieComment(String movieComment) {
        this.movieComment = movieComment == null ? null : movieComment.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}