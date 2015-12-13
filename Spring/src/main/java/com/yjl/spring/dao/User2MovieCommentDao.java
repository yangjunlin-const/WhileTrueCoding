package com.yjl.spring.dao;


import com.yjl.spring.model.User2MovieComment;

import java.util.List;

public interface User2MovieCommentDao {
    int deleteByPrimaryKey(Integer movieCommentId);

    int insert(User2MovieComment record);

    int insertSelective(User2MovieComment record);

    User2MovieComment selectByPrimaryKey(Integer movieCommentId);

    List<User2MovieComment> getAllCommentsByMovieId(Integer movieCommentId);

    int updateByPrimaryKeySelective(User2MovieComment record);

    int updateByPrimaryKey(User2MovieComment record);
}