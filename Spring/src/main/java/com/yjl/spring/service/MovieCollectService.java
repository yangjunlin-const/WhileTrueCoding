package com.yjl.spring.service;


import com.yjl.spring.model.Movie;

import java.util.List;

/**
 * Created by ziew on 2015/5/24.
 */
public interface MovieCollectService {
    int addCollect(int user_id, int movie_id);
    int cancelCollect(int user_id, int movie_id);
    List<Movie> getAllCollections(int user_id);
}
