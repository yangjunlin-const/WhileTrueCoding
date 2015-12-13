package com.yjl.spring.controller;

import com.yjl.spring.model.Movie;
import com.yjl.spring.model.User;
import com.yjl.spring.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shirlies on 15-5-13.
 */


@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    private MovieService movieService;
    //下面的字符串数组为电影类型集合，为了在控制器里直接检测type类型是否正确在此设置了此数组，可以考虑放在配置文件中
    private final String[] movieTypesCollect = {"Action","Adventure","Animation","Children's","Comedy"
            ,"Crime","Documentary","Drama","Fantasy","Film-Noir","Horror","Musical","Mystery","Romance"
    ,"Sci-Fi","Thriller","War","Western"};
    //在首页和类型页推荐的电影显示数量
    private final int recomMoviesCount = 5;
    //home页给用户推荐的电影集
    private static List<Movie> recomMovies;


    @Resource
    public void setMovieService(MovieService movieService){
        this.movieService = movieService;
    }

    /**
     * 当url为/movie/home时，该控制器会处理这个url请求，并从数据库中获得一定量的电影，并根据该用户推荐电影
     * 放在model中，
     * 然后将此数据传给main.jsp页面，在main.jsp页面用jstl读取此数据时，用"homeMovies"名字获取该movies数据
     */
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public ModelAndView getHomeMovie(HttpSession httpSession) throws IOException {

        /*
        获得home页的最新最热电影
         */
        List<Movie> movies = movieService.getMoviesForHome();
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("homeMovies",movies);

        /*
        获得home页根据登录用户情况进行推荐
         */
        recomMovies = null;
        User user = (User)httpSession.getAttribute("user");
        //if(user != null){
            //String userName = user.getName();
        String userName = "shirlies";
            //这里还得判断该用户的等级，需要根据小璐那边的model来，暂时省了，当作是高级用户
            recomMovies = movieService.getRecomMoviesForUser(userName);
        //}
        //当系统为用户推荐的电影不为空时，则取前几个电影给用户
        if(recomMovies != null){
            List<Movie> homeRecomMovies = new ArrayList<Movie>();
            int i = 0;
            for(Movie movie:recomMovies){
                if(i < recomMoviesCount){
                    homeRecomMovies.add(movie);
                }else {
                    break;
                }
                ++ i;
            }
            model.put("recomMovies",homeRecomMovies);//推荐的电影
        }
        return new ModelAndView("main",model);
    }

    /**
     * 当url为/movie/type/{type}时，该方法将处理请求(type不应该为空，前端需要处理type)
     * 首先会检查url中type是否符合要求，再从数据库中获取该类型电影中最新最热的电影
     * 传给的页面是受类型参数的限制的，即需要为每个类型的电影创建一个jsp页面（或者tile）
     * 在类型的jsp页面中用“typeMovies”名字即可获取movies的数据
     * @param type
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/type/{type}",method = RequestMethod.GET)
    public ModelAndView getTypeMovie(@PathVariable String type) throws IOException {
        boolean typeExist = false;
        for(String constType : movieTypesCollect){
            if(type.equalsIgnoreCase(constType)){
                typeExist = true;
                //如果url的类型存在，因为大小写误差的问题，需将此类型改为movieTypesCollect中存在的类型
                type = constType;
                break;
            }
        }

        //如何url的类型参数有问题，则无需跳转
        if(!typeExist){
            return null;
        }

        List<Movie> movies = movieService.getMoviesForType(type);
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("typeMovies",movies);

        //类型页的推荐电影
        if(recomMovies != null){
            List<Movie> typeRecomMovies = new ArrayList<Movie>();
            int i = 0;
            for(Movie movie:recomMovies){
                if(i < recomMoviesCount){
                    //根据电影id号获得电影类型，并判断电影类型是否与本页面的类型相同
                    List<String> movieType = movieService.getMovieTypeByMovieId(movie.getId());
                    if(movieType != null && movieType.contains(type)){
                        typeRecomMovies.add(movie);
                        ++i;
                    }
                }
            }
            model.put("recomMovies",typeRecomMovies);//推荐的电影
        }
        return new ModelAndView(type + "Movie",model);

    }

    /*
    搜索电影，根据url中的参数获取关键词
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView findMovies(HttpServletRequest request) throws IOException {
        //如果findword是多个词的组合的话，还需进行其他处理，以后再说
        request.setCharacterEncoding("UTF-8");
        String findWord = request.getParameter("search");
        //由于SpringMVC默认编码方式为ISO-8859-1的，所以需要对参数进行编码转换
        byte bb[] = findWord.getBytes("ISO-8859-1");
        findWord = new String(bb,"UTF-8");
        //findWord = "星际";
        List<Movie> movies = movieService.findMovies(findWord);
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("findMovies",movies);

        return new ModelAndView("SearchResult",model);
    }


}
