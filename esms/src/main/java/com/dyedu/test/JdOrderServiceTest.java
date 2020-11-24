package com.dyedu.test;

import com.dyedu.bean.JdItem;
import com.dyedu.bean.JdOrder;
import com.dyedu.mapper.JdOrderDAO;
import com.dyedu.service.JdOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gdx
 * @description 测试JdOrderDAO
 * @date 2020/1/10
 */
public class JdOrderServiceTest {
    public static void main(String[] args) {
        // 构建Spring 容器
        ApplicationContext applicationContext  =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdOrderService service = applicationContext.getBean("orderService",
                JdOrderService.class);
        JdOrder  jdOrder  = new JdOrder();
        jdOrder.setInvoice_id(1);
        jdOrder.setOrder_time(new Timestamp(System.currentTimeMillis()));
        jdOrder.setPayment_id(1);
        jdOrder.setReveive_address_id(1);
        jdOrder.setStatus("订单已经生成");
        jdOrder.setTotal_price(100);
        jdOrder.setUser_id(1);
        jdOrder.setBak("测试");
        // 给订单产生 两个详情
        JdItem item  = new JdItem();
        item.setOrder_id(jdOrder.getOrder_id());
        item.setProduct_id(1);
        item.setProduct_num(2);
        item.setProduct_price(11.28);

        JdItem item2  = new JdItem();
        item2.setOrder_id(jdOrder.getOrder_id());
        item2.setProduct_id(1);
        item2.setProduct_num(2);
        item2.setProduct_price(11.28);
        List<JdItem>  items  = new ArrayList<>();
        items.add(item);
        items.add(item2);
        jdOrder.setItems(items);
        service.addOrderAndItems(jdOrder);
    }
}
