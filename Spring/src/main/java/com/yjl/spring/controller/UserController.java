package com.yjl.spring.controller;

/**
 * Created by YangJunLin on 2015/4/18.
 */

import com.yjl.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/get")
    public ModelAndView getUsers(HttpServletRequest request) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = this.userService.getUserById(userId).getName();
        Map<String,String> model = new HashMap<String, String>();
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("userShow");
//            mav.addObject("username", userName);
 //           return mav;
//        model.addAttribute(userName);
          model.put("username", userName);
        return new ModelAndView("userShow", model);
 //       response.sendRedirect("/userShow.jsp");
//        return "userShow";
    }
}
