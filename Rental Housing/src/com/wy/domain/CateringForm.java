package com.wy.domain;

public class CateringForm {
    private static final long serialVersionUID = 1L;

    private Integer id = -1; // ���ݿ���ˮ��

    private String linkAddress = ""; // ���ӵ�ַ

    private String cateringName = ""; // ��������

    private int merchantId;

    public CateringForm() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getCateringName() {
        return cateringName;
    }

    public void setCateringName(String cateringName) {
        this.cateringName = cateringName;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
}
