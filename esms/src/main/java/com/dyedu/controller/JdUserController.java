package com.dyedu.controller;

import com.dyedu.bean.JdCategory;
import com.dyedu.bean.JdUser;
import com.dyedu.service.JdCategoryService;
import com.dyedu.service.JdUserService;
import com.dyedu.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gdx
 * @description 京东用户的控制器类
 * @date 2019/12/26
 */
@Controller
public class JdUserController {
    @Autowired
    private JdUserService  userService;
    @Autowired
    private JdCategoryService  categoryService;
    @RequestMapping("/toHello")
    public  String  toHello(){
        return  "hello";
    }
    @RequestMapping("/toLogin")
    public  String  toLogin(){
        return  "login";
    }

    /*
     *功能描述
     * @author gdx
     * @date 2019/12/26
            * @param [login_name, password]
               * @param login_name  账号
    	       * @param password 密码
     * @return java.lang.String
     */
    @RequestMapping("/login.do")
    public   String  login(String  login_name, String password, HttpServletRequest request){
        // 收到密码 对密码进行 MD5 和 加盐
        password = MD5Util.md5StrAndSalt(password,login_name);
        JdUser  jdUser  = userService.login(login_name,password);
        if(jdUser != null){
            request.getSession().setAttribute("jdUser",jdUser);
            // 登录成功 就获取图书的直接子分类列表
            List<JdCategory>  categories = categoryService.subCategoryList(1);
            request.setAttribute("categories",categories);
            return  "book";
        }
        request.setAttribute("msg","登录失败");
        return  "login";
    }
    @RequestMapping("/toRegister")
    public  String  toRegister(){
        return  "register";
    }
    @RequestMapping("/register.do")
    public  String  register(JdUser  user,HttpServletRequest request){
        // 注册之前 对密码进行 MD5 和 加盐
        user.setPassword(MD5Util.md5StrAndSalt(user.getPassword(),user.getLogin_name()));
        boolean   rf = userService.register(user);
        if(rf){
            return  "registerOk";
        }
        request.setAttribute("msg","注册失败");
        return   "register";
    }

}
