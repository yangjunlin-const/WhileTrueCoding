package com.yjl.spring.service.impl;

import com.yjl.spring.dao.MovieDao;
import com.yjl.spring.dao.User2MovieCollcetDao;
import com.yjl.spring.model.Movie;
import com.yjl.spring.model.User2MovieCollcetKey;
import com.yjl.spring.service.MovieCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieCollectServiceImpl implements MovieCollectService {
    MovieDao movieDao;
    User2MovieCollcetDao user2MovieCollcetDao;
    @Resource
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Resource
    public void setUser2MovieCollcetDao(User2MovieCollcetDao user2MovieCollcetDao) {
        this.user2MovieCollcetDao = user2MovieCollcetDao;
    }

    public int addCollect(int user_id, int movie_id) {
        User2MovieCollcetKey record = new User2MovieCollcetKey();
        record.setMovieId(movie_id);
        record.setUserId(user_id);
        return   user2MovieCollcetDao.insert(record);
    }

    public int cancelCollect(int user_id, int movie_id) {
        User2MovieCollcetKey record = new User2MovieCollcetKey();
        record.setMovieId(movie_id);
        record.setUserId(user_id);
        return  user2MovieCollcetDao.deleteByPrimaryKey(record);
    }

    public List<Movie> getAllCollections(int user_id) {
        List<User2MovieCollcetKey> collcetKeys=user2MovieCollcetDao.getCollectionsByUserId(user_id);
        List<Movie> movies=new ArrayList<Movie>();
        for(User2MovieCollcetKey collcetKey:collcetKeys)
        {
            Movie movie =movieDao.getMoviesByMovieId(collcetKey.getMovieId());
            movies.add(movie);
        }
        return  movies;
    }
}
