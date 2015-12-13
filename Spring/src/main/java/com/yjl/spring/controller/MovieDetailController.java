package com.yjl.spring.controller;

import com.yjl.spring.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by ziew on 2015/5/17.
 * to show the ditail infomation of the selected movie and relation movies
 */
@Controller
@RequestMapping(value = "/detail")
public class MovieDetailController {
    MovieRecommendService movieRecommendService;
    MovieRatingService movieRatingService;
    MovieCollectService movieCollectService;
    MovieCommentService movieCommentService;
    MovieTagService movieTagService;
    @Resource
    public void setMovieTagService(MovieTagService movieTagService) {
        this.movieTagService = movieTagService;
    }

    @Resource
    public void setMovieRecommendService(MovieRecommendService movieRecommendService) {
        this.movieRecommendService = movieRecommendService;
    }

    @Resource
    public void setMovieRatingService(MovieRatingService movieRatingService) {
        this.movieRatingService = movieRatingService;
    }

    @Resource
    public void setMovieCollectService(MovieCollectService movieCollectService) {
        this.movieCollectService = movieCollectService;
    }

    @Resource
    public void setMovieCommentService(MovieCommentService movieCommentService) {
        this.movieCommentService = movieCommentService;
    }


}
