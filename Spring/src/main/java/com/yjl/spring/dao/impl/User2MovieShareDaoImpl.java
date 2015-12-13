package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.User2MovieShareDao;
import com.yjl.spring.model.User2MovieShareKey;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class User2MovieShareDaoImpl implements User2MovieShareDao {
    private static final String NAME_SPACE = "com.yjl.spring.MovieMapper";
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public int deleteByPrimaryKey(User2MovieShareKey key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey",key);
        sqlSession.close();
        return result;
    }

    public int insert(User2MovieShareKey record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insert", record);
        sqlSession.close();
        return result;
    }

    public int insertSelective(User2MovieShareKey record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);
        sqlSession.close();
        return result;
    }
}
