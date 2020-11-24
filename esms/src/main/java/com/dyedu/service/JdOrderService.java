package com.dyedu.service;

import com.dyedu.bean.JdItem;
import com.dyedu.bean.JdOrder;
import com.dyedu.mapper.JdItemDAO;
import com.dyedu.mapper.JdOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gdx
 * @description 订单服务类
 * @date 2020/1/10
 */
@Service("orderService")
public class JdOrderService {
    @Autowired
    private JdOrderDAO  orderDao;
    @Autowired
    private JdItemDAO   itemDao;
    /** 提供一个服务  根据当前用户 以及 订单状态 获取订单列表 */
    public  List<JdOrder>  orderList(int  user_id,String  status){
        return   orderDao.getOrderList(user_id,status);
    }
    /** 根据订单id 更新订单状态 */
    public  boolean   updateOrderStatus(String  status,int order_id){
        return   orderDao.updateOrderStatus(status,order_id)==1?true:false;
    }
    /** 插入订单 和 订单详情的服务  */
    @Transactional
    public  void  addOrderAndItems(JdOrder  order){
         int  osf = orderDao.insertJdOrder(order);
         List<JdItem> items = order.getItems();


         int  isf = 0;
         for (int i=0;i<items.size();i++){
             // 给每个条目设置 订单生成的id
             items.get(i).setOrder_id(order.getOrder_id());
             isf = itemDao.insertJdItem(items.get(i));
             if(isf == 0){
                 break;
             }
         }
         //isf = 0;
         if(osf == 0 || isf == 0){
             throw new RuntimeException("订单插入失败");
         }
    }

}
