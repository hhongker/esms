package com.dyedu.test;

import com.dyedu.bean.JdUser;
import com.dyedu.service.JdUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gdx
 * @description 用户的测试类
 * @date 2019/12/25
 */
public class JdUserTest {
    public static void main(String[] args) {
        // 构建Spring 容器
        ApplicationContext  applicationContext  =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdUserService  userService = applicationContext.getBean("userService",JdUserService.class);
        JdUser  user  = userService.login("zhangsan2","123");
        System.out.println(user);
        JdUser  user1 = new JdUser();
        user1.setLogin_name("爱德华");
        user1.setPassword("123");
        user1.setEmail("gg@163.com");
        user1.setRecommender("gdx");
        System.out.println(userService.register(user1));
    }
}
