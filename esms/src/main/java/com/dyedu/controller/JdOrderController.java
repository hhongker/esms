package com.dyedu.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.dyedu.bean.JdCartItem;
import com.dyedu.bean.JdOrder;
import com.dyedu.bean.JdReceiveAddress;
import com.dyedu.bean.JdUser;
import com.dyedu.service.JdOrderService;
import com.dyedu.service.JdReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author gdx
 * @description 订单控制器
 * @date 2020/1/8
 */
@Controller
public class JdOrderController {
    @Autowired
    private JdOrderService  orderService;
    @Autowired
    private JdReceiveAddressService   addressService;
    /**订单列表  显示当前用户的订单列表 */
    @RequestMapping("/orderList")
    public  String   orderList(HttpServletRequest request){
        // 根据条件 获取当前用户的订单列表
        JdUser  user  =  (JdUser)request.getSession().getAttribute("jdUser");
        List<JdOrder>  orders = orderService.orderList(
                user == null?-1:user.getUser_id(),"已取消");
        request.setAttribute("orders",orders);
        return   "orderList";
    }
    @RequestMapping("/payReturn")
    public String  payReturn(HttpServletRequest request) throws Exception{
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            request.setAttribute("order_id",out_trade_no);
            request.setAttribute("sum_price",total_amount);
            // 更新数据   把 订单状态 由 等待付款 改成 支付成功
            boolean of = orderService.updateOrderStatus("支付成功",
                    Integer.parseInt(out_trade_no));
            if(!of){
                request.setAttribute("payMsg","更新订单状态失败");
            }
            request.setAttribute("payMsg","支付成功");
            return "orderInfo";
            //out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
        }else {
            //out.println("验签失败");
            // 即使验证签名 失败其实也付款成功了   这时候你可以记录日志
        }
        return  "";
    }
    @RequestMapping("/orderInfo")
    public String  orderInfo(HttpServletRequest request) {
        double  sum_price = 0.0;
        List<JdCartItem> cart = (List<JdCartItem>)request.getSession().getAttribute("cart");
        for(JdCartItem temp:cart){
            sum_price += temp.getLower_price()*temp.getProduct_count();
        }
        String  order_id = request.getParameter("order_id");
        // 订单价格如果不变了  可以放入session 中
        request.getSession().setAttribute("sum_price",sum_price);
        request.setAttribute("order_id",order_id);
        return  "orderInfo";
    }
    @RequestMapping("/orderSuccess")
    public String  orderSuccess(HttpServletRequest request) {
        // 随时计算总价格的
        double  sum_price = 0.0;
        List<JdCartItem> cart = (List<JdCartItem>)request.getSession().getAttribute("cart");
        for(JdCartItem temp:cart){
            sum_price += temp.getLower_price()*temp.getProduct_count();
        }
        String  order_id = request.getParameter("order_id");
        request.setAttribute("sum_price",sum_price);
        request.setAttribute("order_id",order_id);
        return  "orderSuccess";
    }
    @RequestMapping("/orderInfoSure")
    public String  orderInfoSure(HttpServletRequest request){
        // 从session 中 获取用户
        JdUser  user  =  (JdUser)request.getSession().getAttribute("jdUser");
        // 在这里使用Service 获取地址
        JdReceiveAddress  address  = addressService.defaultAddressByUserId(user.getUser_id());
        request.setAttribute("address",address);
        // 重新计算总价格
        double  sum_price = 0.0;
        List<JdCartItem> cart = (List<JdCartItem>)request.getSession().getAttribute("cart");
        for(JdCartItem temp:cart){
            sum_price += temp.getLower_price()*temp.getProduct_count();
        }
        request.setAttribute("sum_price",sum_price);
        return  "orderInfoSure";
    }
    @RequestMapping("/orderSubmit")
    @ResponseBody
    public Map<String,String>  orderSubmit(@RequestBody  JdOrder  order, HttpServletRequest request){

        Map<String,String>  res  = new HashMap<>();
        res.put("location","orderSuccess");
        double  sum_price = 0.0;
        List<JdCartItem> cart = (List<JdCartItem>)request.getSession().getAttribute("cart");
        for(JdCartItem temp:cart){
            sum_price += temp.getLower_price()*temp.getProduct_count();
        }
        res.put("sum_price",sum_price+"");
        order.setOrder_time(new Timestamp(System.currentTimeMillis()));
        order.setPayment_id(1);
        order.setInvoice_id(1);
        // 需要设置用户的id
        // 从session 中 获取用户
        JdUser  user  =  (JdUser)request.getSession().getAttribute("jdUser");
        order.setUser_id(user == null ? -1:user.getUser_id());
        System.out.println(order);
        orderService.addOrderAndItems(order);
        res.put("order_id",order.getOrder_id()+"");
        System.out.println(order);
        return   res;
    }
}
