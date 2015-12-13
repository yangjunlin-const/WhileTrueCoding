package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.User2MovieTagDao;
import com.yjl.spring.model.User2MovieTag;
import com.yjl.spring.model.User2MovieTagKey;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class User2MovieTagDaoImpl implements User2MovieTagDao {
    private static final String NAME_SPACE = "com.yjl.spring.MovieMapper";
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public int deleteByPrimaryKey(User2MovieTagKey key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey",key);
        sqlSession.close();
        return result;
    }

    public int insert(User2MovieTag record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insert", record);
        sqlSession.close();
        return result;
    }

    public int insertSelective(User2MovieTag record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);
        sqlSession.close();
        return result;
    }

    public User2MovieTag selectByPrimaryKey(User2MovieTagKey key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User2MovieTag result = sqlSession.selectOne(NAME_SPACE + ".selectByPrimaryKey",  key);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKeySelective(User2MovieTag record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKeySelective",record);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKey(User2MovieTag record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKey",record);
        sqlSession.close();
        return result;
    }
}
