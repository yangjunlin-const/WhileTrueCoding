package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.UserDao;
import com.yjl.spring.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by YangJunLin on 2015/4/18.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final String NAME_SPACE = "com.yjl.spring.UserMapper";

    private SqlSessionFactory sqlSessionFactory;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User getUser(int userId) {
//        Map<String, Object> param = new HashMap<String, Object>();
//        param.put("id", userId);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User result = sqlSession.selectOne(NAME_SPACE + ".selectUserList", String.valueOf(userId));
        int id = result.getId();
        System.out.println(id);
        sqlSession.close();
        return result;
    }

}
