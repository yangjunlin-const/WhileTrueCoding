package com.yjl.spring.service;


import com.yjl.spring.model.Movie;

import java.util.List;

/**
 * Created by shirlies on 15-5-13.
 */
public interface MovieService {
    //为首页获得电影集合
    public List<Movie> getMoviesForHome();

    //为类型页面获得电影集合
    public List<Movie> getMoviesForType(String movieType);

    //搜索电影
    public List<Movie> findMovies(String findWord);

    //根据登录用户名获得推荐的电影
    public List<Movie> getRecomMoviesForUser(String userName);

    //根据电影id获得电影类型，一个电影Id对应多个电影类型
    public List<String> getMovieTypeByMovieId(int movieId);
}
