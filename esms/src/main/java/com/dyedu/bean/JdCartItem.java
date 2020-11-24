package com.dyedu.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author gdx
 * @description 购物车条目类
 * @date 2020/1/6
 */
public class JdCartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdCartItem cartItem = (JdCartItem) o;
        return product_id == cartItem.product_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(product_id);
    }

    @Override
    public String toString() {
        return "JdCartItem{" +
                "product_id=" + product_id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", lower_price=" + lower_price +
                ", back_money=" + back_money +
                ", score=" + score +
                ", product_count=" + product_count +
                '}';
    }

    public JdCartItem(int product_id, String picture, String name, double lower_price, double back_money, double score, int product_count) {
        this.product_id = product_id;
        this.picture = picture;
        this.name = name;
        this.lower_price = lower_price;
        this.back_money = back_money;
        this.score = score;
        this.product_count = product_count;
    }

    public JdCartItem() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLower_price() {
        return lower_price;
    }

    public void setLower_price(double lower_price) {
        this.lower_price = lower_price;
    }

    public double getBack_money() {
        return back_money;
    }

    public void setBack_money(double back_money) {
        this.back_money = back_money;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    private  int  product_id;
    private  String picture;
    private  String name;
    private  double lower_price;
    private  double back_money;
    private  double  score;
    private  int   product_count;

}
