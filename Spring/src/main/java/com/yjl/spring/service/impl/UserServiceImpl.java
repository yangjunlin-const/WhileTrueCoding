package com.yjl.spring.service.impl;

import com.yjl.spring.dao.UserDao;
import com.yjl.spring.model.User;
import com.yjl.spring.service.UserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YangJunLin on 2015/4/18.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public User getUserById(int userId) {
        return userDao.getUser(userId);
    }


}
