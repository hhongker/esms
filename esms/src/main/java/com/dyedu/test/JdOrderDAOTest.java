package com.dyedu.test;

import com.dyedu.bean.JdOrder;
import com.dyedu.mapper.JdOrderDAO;
import com.dyedu.service.JdReceiveAddressService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * @author gdx
 * @description 测试JdOrderDAO
 * @date 2020/1/10
 */
public class JdOrderDAOTest {
    public static void main(String[] args) {
        // 构建Spring 容器
        ApplicationContext applicationContext  =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdOrderDAO  dao = applicationContext.getBean("jdOrderDAO",JdOrderDAO.class);
        JdOrder  jdOrder  = new JdOrder();
        jdOrder.setInvoice_id(1);
        jdOrder.setOrder_time(new Timestamp(System.currentTimeMillis()));
        jdOrder.setPayment_id(1);
        jdOrder.setReveive_address_id(1);
        jdOrder.setStatus("订单已经生成");
        jdOrder.setTotal_price(100);
        jdOrder.setUser_id(1);
        jdOrder.setBak("测试");
        int rows = dao.insertJdOrder(jdOrder);
        System.out.println("rows="+rows);
        System.out.println(jdOrder);
    }
}
