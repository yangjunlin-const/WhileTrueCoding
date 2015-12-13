package com.yjl.spring.service.impl;

import com.yjl.spring.dao.User2MovieShareDao;
import com.yjl.spring.model.User2MovieShareKey;
import com.yjl.spring.service.MovieShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieShareServiceImpl implements MovieShareService {


    User2MovieShareDao user2MovieShareDao;

    @Resource
    public void setUser2MovieShareDao(User2MovieShareDao user2MovieShareDao) {
        this.user2MovieShareDao = user2MovieShareDao;
    }

    public int shareMovie(int userId, int movieId) {
        User2MovieShareKey shareKey = new User2MovieShareKey();
        shareKey.setUserId(userId);
        shareKey.setMovieId(movieId);
        return user2MovieShareDao.insertSelective(shareKey);
    }
}
