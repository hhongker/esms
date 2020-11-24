package com.dyedu.service;

import com.dyedu.bean.JdUser;
import com.dyedu.mapper.JdUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gdx
 * @description 用户的服务类
 * @date 2019/12/25
 */
@Service("userService")
public class JdUserService {
    @Autowired
    private JdUserDAO   userDao;
    public JdUser   login(String login_name,String password){
        return   userDao.findJdUser(login_name,password);
    }
    /*
     * 这是一个注册方法
     * @author gdx
     * @date 2019/12/27
     * @param [user]
     * @param user  注册的用户信息
     * @return boolean
     */
    public  boolean  register(JdUser user){
        try {
            return  userDao.insertJdUser(user)==1?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
}
