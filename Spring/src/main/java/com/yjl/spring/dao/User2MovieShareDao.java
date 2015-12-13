package com.yjl.spring.dao;

import com.yjl.spring.model.User2MovieShareKey;

public interface User2MovieShareDao{
    int deleteByPrimaryKey(User2MovieShareKey key);

    int insert(User2MovieShareKey record);

    int insertSelective(User2MovieShareKey record);
}