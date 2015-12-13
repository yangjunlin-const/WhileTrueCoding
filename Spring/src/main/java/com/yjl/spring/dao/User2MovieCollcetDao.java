package com.yjl.spring.dao;

import com.yjl.spring.model.User2MovieCollcetKey;

import java.util.List;

public interface User2MovieCollcetDao {
    int deleteByPrimaryKey(User2MovieCollcetKey key);

    int insert(User2MovieCollcetKey record);

    int insertSelective(User2MovieCollcetKey record);

    List<User2MovieCollcetKey> getCollectionsByUserId(int userId);
}