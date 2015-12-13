package com.yjl.spring.service;


import com.yjl.spring.model.Movie;

import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
public interface MovieRecommendService {
    //根据电影ID获取推荐的电影
    List<Movie> getRecommendMovies(Integer movie_id);
}
