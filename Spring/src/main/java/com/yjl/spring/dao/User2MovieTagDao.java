package com.yjl.spring.dao;

import com.yjl.spring.model.User2MovieTag;
import com.yjl.spring.model.User2MovieTagKey;

public interface User2MovieTagDao {
    int deleteByPrimaryKey(User2MovieTagKey key);

    int insert(User2MovieTag record);

    int insertSelective(User2MovieTag record);

    User2MovieTag selectByPrimaryKey(User2MovieTagKey key);

    int updateByPrimaryKeySelective(User2MovieTag record);

    int updateByPrimaryKey(User2MovieTag record);
}