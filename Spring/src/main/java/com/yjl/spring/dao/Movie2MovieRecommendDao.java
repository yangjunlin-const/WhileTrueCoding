package com.yjl.spring.dao;

import com.yjl.spring.model.Movie2MovieRecommend;

public interface Movie2MovieRecommendDao {
    int deleteByPrimaryKey(Integer recomId);

    int insert(Movie2MovieRecommend record);

    int insertSelective(Movie2MovieRecommend record);

    Movie2MovieRecommend selectByPrimaryKey(Integer recomId);

    Movie2MovieRecommend selectByMovieId(Integer movieId);

    int updateByPrimaryKeySelective(Movie2MovieRecommend record);

    int updateByPrimaryKey(Movie2MovieRecommend record);
}