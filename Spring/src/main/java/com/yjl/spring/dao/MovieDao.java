package com.yjl.spring.dao;

import com.yjl.spring.model.Movie;

import java.util.List;

/**
 * Created by shirlies on 15-5-11.
 */
public interface MovieDao {
    /*
    为主页获得最新最热的电影，即从所有电影中找到最新的评分高的电影
     */
    public List<Movie> getNewRatingMovieForHome();
    /*
    为某种类型的页面获得最新最热电影，即从某类型的电影中找到最新的评分高的电影
     */
    public List<Movie> getNewRatingTypeMovieForType(String movieType);
    /*
    搜索电影时，输入的为关键词，获得与关键词相关的电影列表
     */
    public List<Movie> findMovies(String findWord);

    /*
    根据用户名获得的电影是一个字符串集合，电影用逗号隔开,然后处理该电影名集合获得电影详细情况
     */
    public List<Movie> getRecomMoviesForUser(String userName);

    /*
    根据电影id获得电影类型,一个电影的电影类型可能有很多
     */
    public List<String> getMovieTypeByMovieId(int movieId);
    /*
    find moive by id
     */
    public Movie getMoviesByMovieId(int movieId);
}
