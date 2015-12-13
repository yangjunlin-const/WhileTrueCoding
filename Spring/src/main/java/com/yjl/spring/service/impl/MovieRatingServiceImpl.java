package com.yjl.spring.service.impl;

import com.yjl.spring.dao.User2MovieRateDao;
import com.yjl.spring.model.User2MovieRate;
import com.yjl.spring.service.MovieRatingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieRatingServiceImpl implements MovieRatingService {

    User2MovieRateDao user2MovieRateDao;

    @Resource
    public void setUser2MovieRateDao(User2MovieRateDao user2MovieRateDao) {
        this.user2MovieRateDao = user2MovieRateDao;
    }

    public int rateMovie(int userId, int movieId, double rate) {
        User2MovieRate movieRate = new User2MovieRate();
        movieRate.setMovieId(movieId);
        movieRate.setUserId(userId);
        movieRate.setRating(rate);
        movieRate.setRatingTime(new Date());
        return user2MovieRateDao.insertSelective(movieRate);
    }
}
