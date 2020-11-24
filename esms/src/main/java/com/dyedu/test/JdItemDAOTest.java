package com.dyedu.test;

import com.dyedu.bean.JdItem;
import com.dyedu.bean.JdOrder;
import com.dyedu.mapper.JdItemDAO;
import com.dyedu.mapper.JdOrderDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * @author gdx
 * @description 测试JdOrderDAO
 * @date 2020/1/10
 */
public class JdItemDAOTest {
    public static void main(String[] args) {
        // 构建Spring 容器
        ApplicationContext applicationContext  =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdItemDAO  dao = applicationContext.getBean("jdItemDAO",JdItemDAO.class);
        JdItem   item  = new JdItem();
        item.setOrder_id(4);
        item.setProduct_id(1);
        item.setProduct_num(2);
        item.setProduct_price(11.28);
        int rows = dao.insertJdItem(item);
        System.out.println("rows="+rows);
    }
}
