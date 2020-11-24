package com.dyedu.bean;

/**
 * @author gdx
 * @description 订单详情
 * @date 2020/1/10
 */
public class JdItem {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "JdItem{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_num=" + product_num +
                ", product_price=" + product_price +
                '}';
    }

    public JdItem() {
    }

    public JdItem(int id, int order_id, int product_id, int product_num, double product_price) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_num = product_num;
        this.product_price = product_price;
    }

    private int  id;
    private int  order_id;
    private  int  product_id;
    private  int  product_num;
    private  double  product_price;
}
