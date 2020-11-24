package com.dyedu.mapper;

import com.dyedu.bean.JdProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JdProductDAO {
    List<JdProduct> getProductListByPageInfo(@Param("category_id") int category_id,
                                             @Param("order_std")String  order_std,
                                             @Param("order_type")String order_type,
                                             @Param("start_pos")int start_pos,
                                             @Param("page_size")int  page_size);

    int   getProductCountByCategoryId(@Param("category_id") int  category_id);
    JdProduct  getProductById(@Param("product_id") int  product_id);
}
