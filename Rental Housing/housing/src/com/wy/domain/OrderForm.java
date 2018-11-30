package com.wy.domain;

import javax.servlet.http.*;

import org.apache.struts.action.*;

/**
 * Order Form
 */
public class OrderForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String address;
    private String bz;
    private Integer id;
    private String name;
    private String number;
    private String post;
    private String reallyName;
    private String money;
    private String sign;
    private String tel;
    private String createTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setReallyName(String reallyName) {
        this.reallyName = reallyName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public void setCreateTime(String creaTime) {
        this.createTime = creaTime;
    }

    public String getBz() {
        return bz;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPost() {
        return post;
    }

    public String getReallyName() {
        return reallyName;
    }

    public String getMoney() {
        return money;
    }

    public String getSign() {
        return sign;
    }

    public String getTel() {
        return tel;
    }

    public String getCreateTime() {
        return createTime;
    }

    @Override
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
