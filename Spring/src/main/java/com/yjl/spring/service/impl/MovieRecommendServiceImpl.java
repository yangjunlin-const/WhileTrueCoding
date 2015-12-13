package com.yjl.spring.service.impl;

import com.yjl.spring.dao.Movie2MovieRecommendDao;
import com.yjl.spring.dao.MovieDao;
import com.yjl.spring.model.Movie;
import com.yjl.spring.model.Movie2MovieRecommend;
import com.yjl.spring.service.MovieRecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieRecommendServiceImpl implements MovieRecommendService {
    private MovieDao movieDao;


    private Movie2MovieRecommendDao movie2MovieRecommendDao;

    @Resource
    public void setMovieDao(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @Resource
    public void setMovie2MovieRecommendDao(Movie2MovieRecommendDao movie2MovieRecommendDao) {
        this.movie2MovieRecommendDao = movie2MovieRecommendDao;
    }

    public List<Movie> getRecommendMovies(Integer movie_id) {
        List<Movie> movies=new ArrayList<Movie>();
        Movie2MovieRecommend recommend = movie2MovieRecommendDao.selectByMovieId(movie_id);
        if(recommend!=null)
        {
            String[] movieIds =recommend.getRecomMovieIds().split(",");
            for(String movieId : movieIds){
                movies.add(movieDao.getMoviesByMovieId(Integer.valueOf(movieId)));
            }
        }
        return  movies;
    }
}
