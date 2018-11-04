package com.wy.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

//house bean
public class HouseForm extends ActionForm {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String creaTime;

    private Float freePrice;

    private String from;

    private String introduce;

    private String name;

    private Float nowPrice;

    private Integer number;

    private Integer small;

    private Integer big;

    private String priture;

    private Integer mark;

    private FormFile formFile;
    private int merchantId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getBig() {
        return big;
    }

    public void setBig(Integer big) {
        this.big = big;
    }

    public String getCreaTime() {
        return creaTime;
    }

    public void setCreaTime(String creaTime) {
        this.creaTime = creaTime;
    }

    public FormFile getFormFile() {
        return formFile;
    }

    public void setFormFile(FormFile formFile) {
        this.formFile = formFile;
    }

    public Float getFreePrice() {
        return freePrice;
    }

    public void setFreePrice(Float freePrice) {
        this.freePrice = freePrice;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Float nowPrice) {
        this.nowPrice = nowPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPriture() {
        return priture;
    }

    public void setPriture(String priture) {
        this.priture = priture;
    }

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        this.small = small;
    }

}
