package com.dyedu.mapper;

import com.dyedu.bean.JdOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JdOrderDAO {
    int  insertJdOrder(JdOrder jdOrder);
    int  updateOrderStatus(@Param("status") String  status,
                           @Param("order_id") int  order_id);
    List<JdOrder>  getOrderList(@Param("user_id") int  user_id,
                                @Param("status") String  status);
}
