package com.yjl.spring.service;

/**
 * Created by ziew on 2015/5/24.
 */
public interface MovieRatingService {
    int rateMovie(int userId, int movieId, double rate);
}
