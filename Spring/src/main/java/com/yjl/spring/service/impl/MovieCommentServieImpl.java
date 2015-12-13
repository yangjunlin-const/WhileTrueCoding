package com.yjl.spring.service.impl;


import com.yjl.spring.dao.User2MovieCommentDao;
import com.yjl.spring.model.User2MovieComment;
import com.yjl.spring.service.MovieCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public class MovieCommentServieImpl implements MovieCommentService {

    User2MovieCommentDao user2MovieCommentDao;

    @Resource
    public void setUser2MovieCommentDao(User2MovieCommentDao user2MovieCommentDao) {
        this.user2MovieCommentDao = user2MovieCommentDao;
    }

    public int addComment(int userId, int movieId, String title, String value, String comment) {
        User2MovieComment user2MovieComment =new User2MovieComment();
        user2MovieComment.setUserId(userId);
        user2MovieComment.setMovieId(movieId);
        user2MovieComment.setCommentTime(new Date());
        user2MovieComment.setMovieTitle(title);
        user2MovieComment.setMovieValue(value);
        return user2MovieCommentDao.insertSelective(user2MovieComment);
    }

    public List<User2MovieComment> getAllComments(int movieId) {
        return  user2MovieCommentDao.getAllCommentsByMovieId(movieId);
    }
}
