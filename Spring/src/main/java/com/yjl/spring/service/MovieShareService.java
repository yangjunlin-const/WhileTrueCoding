package com.yjl.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created by ziew on 2015/5/24.
 */
@Service
public interface MovieShareService {

    int shareMovie(int userId, int movieId);
}
