package com.dyedu.bean;

import java.io.Serializable;

/**
 * @author gdx
 * @description 收货地址类
 * @date 2020/1/9
 */
public class JdReceiveAddress implements Serializable {
    @Override
    public String toString() {
        return "JdReceiveAddress{" +
                "reveive_address_id=" + reveive_address_id +
                ", user_id=" + user_id +
                ", receive_name='" + receive_name + '\'' +
                ", province='" + province + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", area='" + area + '\'' +
                ", is_default=" + is_default +
                '}';
    }

    public JdReceiveAddress() {
    }

    public JdReceiveAddress(int reveive_address_id, int user_id, String receive_name, String province, String address, String zipcode, String mobile, String telephone, String email, String area, int is_default) {
        this.reveive_address_id = reveive_address_id;
        this.user_id = user_id;
        this.receive_name = receive_name;
        this.province = province;
        this.address = address;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.telephone = telephone;
        this.email = email;
        this.area = area;
        this.is_default = is_default;
    }

    public int getReveive_address_id() {
        return reveive_address_id;
    }

    public void setReveive_address_id(int reveive_address_id) {
        this.reveive_address_id = reveive_address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    private  int reveive_address_id;
    private  int user_id;
    private  String receive_name;
    private  String province;
    private  String  address;
    private  String zipcode	;
    private  String  mobile	;
    private  String telephone;
    private  String email	;
    private  String area	;
    private  int     is_default;
}
