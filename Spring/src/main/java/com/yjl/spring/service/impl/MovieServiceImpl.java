package com.yjl.spring.service.impl;

import com.yjl.spring.dao.MovieDao;
import com.yjl.spring.model.Movie;
import com.yjl.spring.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shirlies on 15-5-13.
 */
@Service
public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    @Resource
    public void setMovieDao(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    public List<Movie> getMoviesForHome() {
        return movieDao.getNewRatingMovieForHome();
    }

    public List<Movie> getMoviesForType(String movieType) {
        return movieDao.getNewRatingTypeMovieForType(movieType);
    }

    public List<Movie> findMovies(String findWord) {
        //如果findword是多个搜索词的集合，则此处需对findword进行处理，这里暂时只考虑findword为单个词
        return movieDao.findMovies(findWord);
    }

    public List<Movie> getRecomMoviesForUser(String userName) {
        return movieDao.getRecomMoviesForUser(userName);
    }

    //???
    public List<String> getMovieTypeByMovieId(int movieId) {
        return movieDao.getMovieTypeByMovieId(movieId);
    }
}
