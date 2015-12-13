package com.yjl.spring.service.impl;

import com.yjl.spring.dao.User2MovieTagDao;
import com.yjl.spring.model.User2MovieTag;
import com.yjl.spring.service.MovieTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieTagServiceImpl implements MovieTagService {
    User2MovieTagDao user2MovieTagDao;
    @Resource
    public void setUser2MovieTagDao(User2MovieTagDao user2MovieTagDao) {
        this.user2MovieTagDao = user2MovieTagDao;
    }

    public int addTag(int userId, int movieId, String tag) {
        User2MovieTag movieTag=new User2MovieTag();
        movieTag.setMovieId(movieId);
        movieTag.setUserId(userId);
        movieTag.setTag(tag);
        movieTag.setTagTime(new Date());
        return  user2MovieTagDao.insertSelective(movieTag);
    }
}
