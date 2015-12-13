package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.Movie2MovieRecommendDao;
import com.yjl.spring.model.Movie2MovieRecommend;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class Movie2MovieRecommendDaoImpl implements Movie2MovieRecommendDao {
    private static final String NAME_SPACE = "com.yjl.spring.dao.Movie2MovieRecommendDao";
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int deleteByPrimaryKey(Integer recomId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey", recomId);

        sqlSession.close();
        return result;
    }

    public int insert(Movie2MovieRecommend record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.insert(NAME_SPACE + ".insert", record);

        sqlSession.close();
        return result;
    }

    public int insertSelective(Movie2MovieRecommend record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);

        sqlSession.close();
        return result;
    }

    public Movie2MovieRecommend selectByPrimaryKey(Integer recomId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Movie2MovieRecommend result = sqlSession.selectOne(NAME_SPACE + ".selectByPrimaryKey", recomId);

        sqlSession.close();
        return result;
    }

    public Movie2MovieRecommend selectByMovieId(Integer movieId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Movie2MovieRecommend result = sqlSession.selectOne(NAME_SPACE + ".selectByMovieId",movieId);

        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKeySelective(Movie2MovieRecommend record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.update(NAME_SPACE + ".updateByPrimaryKeySelective", record);

        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKey(Movie2MovieRecommend record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.update(NAME_SPACE + ".updateByPrimaryKey", record);

        sqlSession.close();
        return result;
    }
}
