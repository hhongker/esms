package com.dyedu.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author gdx
 * @description 订单对应的实体类
 * @date 2020/1/10
 */
public class JdOrder implements Serializable {
    @Override
    public String toString() {
        return "JdOrder{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                ", order_time=" + order_time +
                ", total_price=" + total_price +
                ", payment_id=" + payment_id +
                ", invoice_id=" + invoice_id +
                ", reveive_address_id=" + reveive_address_id +
                ", bak='" + bak + '\'' +
                ", items=" + items +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getReveive_address_id() {
        return reveive_address_id;
    }

    public void setReveive_address_id(int reveive_address_id) {
        this.reveive_address_id = reveive_address_id;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public JdOrder() {
    }

    public JdOrder(int order_id, int user_id, String status, Timestamp order_time, double total_price, int payment_id, int invoice_id, int reveive_address_id, String bak) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.status = status;
        this.order_time = order_time;
        this.total_price = total_price;
        this.payment_id = payment_id;
        this.invoice_id = invoice_id;
        this.reveive_address_id = reveive_address_id;
        this.bak = bak;
    }

    public List<JdItem> getItems() {
        return items;
    }

    public void setItems(List<JdItem> items) {
        this.items = items;
    }

    private int  order_id;
    private int user_id;
    private String  status;
    private Timestamp  order_time;
    private  double total_price;
    private int payment_id;
    private int invoice_id;
    private int reveive_address_id;
    private String bak;
    private List<JdItem>  items;
}
