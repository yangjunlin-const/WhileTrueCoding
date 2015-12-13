package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.User2MovieRateDao;
import com.yjl.spring.model.User2MovieRate;
import com.yjl.spring.model.User2MovieRateKey;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class User2MovieRateDaoImpl implements User2MovieRateDao {
    private static final String NAME_SPACE = "com.yjl.spring.MovieMapper";
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public int deleteByPrimaryKey(User2MovieRateKey key) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey", key);
        sqlSession.close();
        return result;
    }

    public int insert(User2MovieRate record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insert", record);
        sqlSession.close();
        return result;
    }

    public int insertSelective(User2MovieRate record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);
        sqlSession.close();
        return result;
    }

    public User2MovieRate selectByPrimaryKey(User2MovieRateKey key) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User2MovieRate result = sqlSession.selectOne(NAME_SPACE + ".selectByPrimaryKey",key);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKeySelective(User2MovieRate record) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKeySelective",record);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKey(User2MovieRate record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKey",record);
        sqlSession.close();
        return result;
    }
}
