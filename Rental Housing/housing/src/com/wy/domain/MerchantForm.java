package com.wy.domain;

import org.apache.struts.action.ActionForm;

/**
 * Merchant Form
 */
public class MerchantForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private int id;
    private String merchantName;

    public MerchantForm(int id, String merchantName) {
        this.id = id;
        this.merchantName = merchantName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
