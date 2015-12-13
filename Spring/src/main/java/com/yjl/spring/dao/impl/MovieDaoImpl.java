package com.yjl.spring.dao.impl;

import com.yjl.spring.dao.MovieDao;
import com.yjl.spring.model.Movie;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shirlies on 15-5-11.
 */
@Repository
public class MovieDaoImpl implements MovieDao {
    private static final String NAME_SPACE = "com.yjl.spring.MovieMapper";
    private SqlSessionFactory sqlSessionFactory;

    //设置获取最新最热电影的个数，这里是魔数，可以考虑放在配置文件中
    private int newRatingMovieCount = 100;
    //限制搜索到的电影的最大数量
    private int maxCount = 10;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    //根据电影id获得电影信息
    public Movie getMoviesByMovieId(int movieId){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Movie result = sqlSession.selectOne(NAME_SPACE + ".getMovieByMovieId",movieId);

        sqlSession.close();
        return result;
    }

    public List<Movie> getNewRatingMovieForHome() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Movie> result = sqlSession.selectList(NAME_SPACE + ".selectNewRatingMovieList",newRatingMovieCount);

        sqlSession.close();
        return result;
    }

    public List<Movie> getNewRatingTypeMovieForType(String movieType) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("movieType",movieType);
        map.put("newRatingMovieCount",newRatingMovieCount);
        List<Movie> result = sqlSession.selectList(NAME_SPACE+".selectNewRatingTypeMovieList",map);

        sqlSession.close();
        return result;
    }

    public List<Movie> findMovies(String findWord) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("findWord","%" + findWord + "%");
        map.put("maxCount", maxCount);

        //搜索电影名获得电影集合
        List<Movie> result = sqlSession.selectList(NAME_SPACE + ".findMovieByMovieName",map);

        //搜索电影的导演获得电影集合
        List<Movie> tmpResult = sqlSession.selectList(NAME_SPACE + ".findMovieByMovieDirector",map);
        for(Movie m : tmpResult){
            result.add(m);
        }
        tmpResult.clear();

        //搜索电影的类型获得电影集合
        tmpResult = sqlSession.selectList(NAME_SPACE + ".findMovieByMovieType",map);
        for(Movie m : tmpResult){
            result.add(m);
        }
        tmpResult.clear();

        sqlSession.close();
        //返回搜索到的所有电影集合
        return result;
    }

    public List<Movie> getRecomMoviesForUser(String userName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String result = sqlSession.selectOne(NAME_SPACE + ".getMoviesByUserName", userName);
        String[] movieIds = result.split(",");

        List<Movie> movies = new ArrayList<Movie>();
        for(String movieId : movieIds){
            movies.add(this.getMoviesByMovieId(Integer.valueOf(movieId)));
        }

        return movies;
    }

    public List<String> getMovieTypeByMovieId(int movieId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String> result = sqlSession.selectList(NAME_SPACE + ".getMovieTypeByMovieId", movieId);

        return result;
    }
}
