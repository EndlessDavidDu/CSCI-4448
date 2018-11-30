package com.wy.domain;

import org.apache.struts.action.ActionForm;

/**
 * Favorites Form
 */
public class FavoritesForm extends ActionForm {
    private int userId;
    private int houseId;
    private int leaseDays;
    private double totalPrice;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getLeaseDays() {
        return leaseDays;
    }

    public void setLeaseDays(int leaseDays) {
        this.leaseDays = leaseDays;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
