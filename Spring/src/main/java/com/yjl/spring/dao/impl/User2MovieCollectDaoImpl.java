package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.User2MovieCollcetDao;
import com.yjl.spring.model.User2MovieCollcetKey;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class User2MovieCollectDaoImpl implements User2MovieCollcetDao {
    private static final String NAME_SPACE = "com.yjl.spring.dao.User2MovieCollcetMapper";
    private SqlSessionFactory sqlSessionFactory;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int deleteByPrimaryKey(User2MovieCollcetKey key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey", key);

        sqlSession.close();
        return result;
    }

    public int insert(User2MovieCollcetKey record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

       int result = sqlSession.insert(NAME_SPACE + ".insert", record);
        sqlSession.close();
        return result;
    }

    public int insertSelective(User2MovieCollcetKey record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);
        sqlSession.close();
        return result;
    }

    public List<User2MovieCollcetKey> getCollectionsByUserId(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User2MovieCollcetKey> result = sqlSession.selectList(NAME_SPACE + ".insertSelective", userId);
        sqlSession.close();
        return result;
    }
}
