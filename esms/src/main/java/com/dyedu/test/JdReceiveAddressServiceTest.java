package com.dyedu.test;

import com.dyedu.bean.JdReceiveAddress;
import com.dyedu.bean.JdUser;
import com.dyedu.service.JdReceiveAddressService;
import com.dyedu.service.JdUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gdx
 * @description 用户的测试类
 * @date 2019/12/25
 */
public class JdReceiveAddressServiceTest {
    public static void main(String[] args) {
        // 构建Spring 容器
        ApplicationContext  applicationContext  =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdReceiveAddressService addressService  = applicationContext.getBean("addressService",
                JdReceiveAddressService.class);
        System.out.println(addressService.defaultAddressByUserId(1));
    }
}
