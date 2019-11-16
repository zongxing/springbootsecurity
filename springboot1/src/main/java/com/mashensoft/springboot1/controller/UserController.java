package com.mashensoft.springboot1.controller;

import com.mashensoft.springboot1.model.User;
import com.mashensoft.springboot1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 获取所有用户
     * restful api
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> user() {
        //request.getCookies();
        /**
         * request：请求对象
         * 1：头header
         * 2：参数
         * 3:文件，json
         */
        /**
         * response：
         * 1:响应头
         * 2:内容
         * 3:cookie
         */

//        request.getContextPath();
//        response.addCookie(new Cookie("company","mashensoft"));
//        request.get
        //int a  = 1/0;
        List<User> list = userService.getAllUser();
        return list;
    }

    /**
     * restful风格的查询一个对象
     *
     * @param userId Integer类型的id
     * @return User
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer userId) {
        //int a = 1/0;
        System.out.println("=============" + userId);
        return userService.getUser(userId);
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public boolean saveUser(@RequestHeader String userAgent,@RequestHeader String accept){
//        return userService.saveUser(user);
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public boolean saveUser(@RequestHeader String userAgent,@RequestHeader String accept){
//        return userService.saveUser(user);
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public boolean saveUser(HttpSession session){
//        session.setAttribute("user","user");
//        User userFromSession = (User) session.getAttribute("user");
//        return userService.saveUser(user);
//    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public boolean saveUser(@CookieValue String jsessionId,@CookieValue String _ga){
//
//        return true;
//    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable Integer userId) {

        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "/myuser", method = RequestMethod.GET)
    public Map<String, Object> showUser(@RequestParam Map<String, Object> map) {
        System.out.println("===============我是一个快乐的分隔线=================");
        System.out.println(map.toString());
        return map;
    }


}
