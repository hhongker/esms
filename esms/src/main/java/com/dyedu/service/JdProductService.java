package com.dyedu.service;

import com.dyedu.bean.JdProduct;
import com.dyedu.mapper.JdProductDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gdx
 * @description 产品信息类
 * @date 2019/12/31
 */
@Service("productService")
public class JdProductService {
    @Autowired
    private JdProductDAO  productDao;
    /* 根据页面上的信息 获取产品列表 */
    public List<JdProduct>  productListByPageInfo( int category_id,
                                                  String  order_std,
                                                  String order_type,
                                                  int start_pos,
                                                  int  page_size){
         return   productDao.getProductListByPageInfo(category_id,order_std,
                 order_type,start_pos,page_size);
    }
    public   int     productCountByCategoryId(int  category_id){
         return   productDao.getProductCountByCategoryId(category_id);
    }
    public  JdProduct  productById(int product_id){
         return  productDao.getProductById(product_id);
    }
}
