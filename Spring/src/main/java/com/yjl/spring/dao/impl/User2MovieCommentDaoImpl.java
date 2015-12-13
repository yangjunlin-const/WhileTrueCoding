package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.User2MovieCommentDao;
import com.yjl.spring.model.User2MovieComment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
@Repository
public class User2MovieCommentDaoImpl implements User2MovieCommentDao {
    private static final String NAME_SPACE = "com.yjl.spring.MovieMapper";
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public int deleteByPrimaryKey(Integer movieCommentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".deleteByPrimaryKey",movieCommentId);
        sqlSession.close();
        return result;
    }

    public int insert(User2MovieComment record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insert", record);
        sqlSession.close();
        return result;
    }

    public int insertSelective(User2MovieComment record) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert(NAME_SPACE + ".insertSelective", record);
        sqlSession.close();
        return result;
    }

    public User2MovieComment selectByPrimaryKey(Integer movieCommentId) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User2MovieComment result = sqlSession.selectOne(NAME_SPACE + ".selectByPrimaryKey", movieCommentId);
        sqlSession.close();
        return result;
    }

    public List<User2MovieComment> getAllCommentsByMovieId(Integer movieCommentId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User2MovieComment> result = sqlSession.selectList(NAME_SPACE + ".selectByPrimaryKey", movieCommentId);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKeySelective(User2MovieComment record) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKeySelective",record);
        sqlSession.close();
        return result;
    }

    public int updateByPrimaryKey(User2MovieComment record)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete(NAME_SPACE + ".updateByPrimaryKey",record);
        sqlSession.close();
        return result;
    }
}
