package com.yjl.spring.dao;


import com.yjl.spring.model.User2MovieRate;
import com.yjl.spring.model.User2MovieRateKey;

public interface User2MovieRateDao {
    int deleteByPrimaryKey(User2MovieRateKey key);

    int insert(User2MovieRate record);

    int insertSelective(User2MovieRate record);

    User2MovieRate selectByPrimaryKey(User2MovieRateKey key);

    int updateByPrimaryKeySelective(User2MovieRate record);

    int updateByPrimaryKey(User2MovieRate record);
}