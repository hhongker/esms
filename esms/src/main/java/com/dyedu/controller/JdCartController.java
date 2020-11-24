package com.dyedu.controller;

import com.dyedu.bean.JdCartItem;
import com.dyedu.bean.JdProduct;
import com.dyedu.service.JdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gdx
 * @description 购物车控制器
 * @date 2020/1/6
 */
@Controller
public class JdCartController {
    @Autowired
    private JdProductService  productService;
    // 这是购买的请求  当然大家也可以写成buyProduct 或者addCart等
    @RequestMapping("/initCart")
    public String  initCart(int product_id,HttpServletRequest request){
        // 从session 中获取购物车
        List<JdCartItem> cart =  (List<JdCartItem>)request
                .getSession().getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<JdCartItem>();
            request.getSession().setAttribute("cart",cart);
        }
        // 现在需要根据商品的id  封装一个购物车条目对象
        // 需要先有一个根据商品id 获取商品信息的方法
        JdProduct  product = productService.productById(product_id);
        //System.out.println(product);
        //需要把 product  转换成一个购物车条目对象
        JdCartItem  item = product.convertToCartItem();
        if(cart.contains(item)){
            // 需要取出 购物车条目 让其数量加1
            for(JdCartItem  temp:cart){
                if(temp.equals(item)){
                    temp.setProduct_count(temp.getProduct_count()+1);
                    break;
                }
            }
            // 这里用不用把 item 再次加入到car中? cart 要不要重新加入到session?
        }else{
            cart.add(item);
        }
        // 计算总数量 和 总价格
        int sum_count = 0;
        double sum_price = 0;
        for (JdCartItem temp : cart){
            sum_count += temp.getProduct_count();
            sum_price += (temp.getLower_price() * temp.getProduct_count());
        }
        request.setAttribute("sum_count",sum_count);
        request.setAttribute("sum_price",sum_price);
        return "initCart";
    }

    @RequestMapping("/myCart")
    public String  myCart(HttpServletRequest request){
        // 计算好总金额  放到session 中是否可行? 每次用都计算?
        double sum_price = 0;
        List<JdCartItem> cart =  (List<JdCartItem>)request
                .getSession().getAttribute("cart");

        for (JdCartItem temp : cart){
            sum_price += (temp.getLower_price() * temp.getProduct_count());
        }
        request.setAttribute("sum_price",sum_price);
        return "myCart";
    }
    /** 对购物车中的商品条目进行加操作 */
    @RequestMapping("/addCartItemCount")
    @ResponseBody
    public Map<String,Object> addCartItemCount(int  product_id,HttpServletRequest request){
         Map<String,Object>  res  = new HashMap<String,Object>();
         // 获取session 中的 cart
         List<JdCartItem> cart  = ( List<JdCartItem>)request.getSession().getAttribute("cart");
         for (JdCartItem item : cart){
             if(item.getProduct_id() == product_id){
                 item.setProduct_count(item.getProduct_count()+1);
                 res.put("item_count",item.getProduct_count());
                 break;
             }
         }
         // 计算出购物车的总价格
        double  sum_price = 0;
        for (JdCartItem temp : cart){
            sum_price += (temp.getLower_price() * temp.getProduct_count());
        }
        res.put("sum_price",sum_price);
        return  res;
    }

    @RequestMapping("/subCartItemCount")
    @ResponseBody
    public Map<String,Object> subCartItemCount(int  product_id,HttpServletRequest request){
        Map<String,Object>  res  = new HashMap<String,Object>();
        // 获取session 中的 cart
        List<JdCartItem> cart  = ( List<JdCartItem>)request.getSession().getAttribute("cart");
        for (JdCartItem item : cart){
            if(item.getProduct_id() == product_id){
                item.setProduct_count(item.getProduct_count()-1);
                res.put("item_count",item.getProduct_count());
                break;
            }
        }
        // 计算出购物车的总价格
        double  sum_price = 0;
        for (JdCartItem temp : cart){
            sum_price += (temp.getLower_price() * temp.getProduct_count());
        }
        res.put("sum_price",sum_price);
        return  res;
    }

    @RequestMapping("/deleteCartItem")
    @ResponseBody
    public Map<String,Object> deleteCartItem(int  product_id,HttpServletRequest request){
        Map<String,Object>  res  = new HashMap<String,Object>();
        // 获取session 中的 cart
        List<JdCartItem> cart  = ( List<JdCartItem>)request.getSession().getAttribute("cart");
        for (JdCartItem item : cart){
            if(item.getProduct_id() == product_id){
                // 从集合中删除 这个条目
                cart.remove(item);
                res.put("status",true);
                break;
            }
        }
        // 计算出购物车的总价格
        double  sum_price = 0;
        for (JdCartItem temp : cart){
            sum_price += (temp.getLower_price() * temp.getProduct_count());
        }
        res.put("sum_price",sum_price);
        return  res;
    }
}
