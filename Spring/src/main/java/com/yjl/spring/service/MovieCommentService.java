package com.yjl.spring.service;

import com.yjl.spring.model.User2MovieComment;

import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
public interface MovieCommentService {

    /*

     */
    int addComment(int userId, int movieId, String title, String value, String comment);

    List<User2MovieComment> getAllComments(int movieId);
}
