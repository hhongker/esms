package com.dyedu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author gdx
 * @description 封装京东用户的实体类
 * @date 2019/12/25
 */
public class JdUser implements Serializable {
    @Override
    public String toString() {
        return "JdUser{" +
                "user_id=" + user_id +
                ", login_name='" + login_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", real_name='" + real_name + '\'' +
                ", grade_id=" + grade_id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", recommender='" + recommender + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", location='" + location + '\'' +
                ", school='" + school + '\'' +
                ", company='" + company + '\'' +
                ", card_int='" + card_int + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", msn='" + msn + '\'' +
                ", qq='" + qq + '\'' +
                ", website='" + website + '\'' +
                ", send_address='" + send_address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", hobby='" + hobby + '\'' +
                ", verify_flag='" + verify_flag + '\'' +
                ", verify_code='" + verify_code + '\'' +
                ", last_login_time=" + last_login_time +
                ", last_login_ip='" + last_login_ip + '\'' +
                ", area='" + area + '\'' +
                ", head_pic='" + head_pic + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCard_int() {
        return card_int;
    }

    public void setCard_int(String card_int) {
        this.card_int = card_int;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSend_address() {
        return send_address;
    }

    public void setSend_address(String send_address) {
        this.send_address = send_address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getVerify_flag() {
        return verify_flag;
    }

    public void setVerify_flag(String verify_flag) {
        this.verify_flag = verify_flag;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public Timestamp getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Timestamp last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public JdUser() {
    }

    public JdUser(int user_id, String login_name, String nick_name, String real_name, int grade_id, String password, String email, String province, String recommender, String sex, Timestamp birth, String location, String school, String company, String card_int, String mobile, String phone, String msn, String qq, String website, String send_address, String zipcode, String hobby, String verify_flag, String verify_code, Timestamp last_login_time, String last_login_ip, String area, String head_pic) {
        this.user_id = user_id;
        this.login_name = login_name;
        this.nick_name = nick_name;
        this.real_name = real_name;
        this.grade_id = grade_id;
        this.password = password;
        this.email = email;
        this.province = province;
        this.recommender = recommender;
        this.sex = sex;
        this.birth = birth;
        this.location = location;
        this.school = school;
        this.company = company;
        this.card_int = card_int;
        this.mobile = mobile;
        this.phone = phone;
        this.msn = msn;
        this.qq = qq;
        this.website = website;
        this.send_address = send_address;
        this.zipcode = zipcode;
        this.hobby = hobby;
        this.verify_flag = verify_flag;
        this.verify_code = verify_code;
        this.last_login_time = last_login_time;
        this.last_login_ip = last_login_ip;
        this.area = area;
        this.head_pic = head_pic;
    }

    private  int  user_id;
    private  String login_name	;
    private  String nick_name	;
    private  String real_name	;
    private  int  grade_id;
    private  String password;
    private  String email;
    private  String province;
    private  String recommender;
    private  String sex	;
    private  Timestamp birth;
    private  String location;
    private  String school;
    private  String company	;
    private  String card_int	;
    private  String mobile	;
    private  String phone	;
    private  String msn	;
    private  String qq	;
    private  String website	;
    private  String send_address;
    private  String zipcode;
    private  String hobby	;
    private  String verify_flag	;
    private  String verify_code	;
    private  Timestamp last_login_time;
    private  String last_login_ip;
    private  String area;
    private  String head_pic;
}
