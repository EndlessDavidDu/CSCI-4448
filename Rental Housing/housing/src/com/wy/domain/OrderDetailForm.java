package com.wy.domain;

import javax.servlet.http.*;

import org.apache.struts.action.*;

/**
 * Order Detail Form
 */
public class OrderDetailForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer houseId;
    private Integer id;
    private String orderNumber;
    private float price;

    private int number;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
