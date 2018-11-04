package com.wy.domain;

import org.apache.struts.action.ActionForm;

public class OrderDetailsForm extends ActionForm {
    private int paymentMethod;
    private int  checkInOrNot;
    private String noteInfo;
    private MemberForm memberForm;
    private HouseForm houseForm;
    private FavoritesForm favoritesForm;

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getCheckInOrNot() {
        return checkInOrNot;
    }

    public void setCheckInOrNot(int checkInOrNot) {
        this.checkInOrNot = checkInOrNot;
    }

    public String getNoteInfo() {
        return noteInfo;
    }

    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo;
    }

    public MemberForm getMemberForm() {
        return memberForm;
    }

    public void setMemberForm(MemberForm memberForm) {
        this.memberForm = memberForm;
    }

    public HouseForm getHouseForm() {
        return houseForm;
    }

    public void setHouseForm(HouseForm houseForm) {
        this.houseForm = houseForm;
    }

    public FavoritesForm getFavoritesForm() {
        return favoritesForm;
    }

    public void setFavoritesForm(FavoritesForm favoritesForm) {
        this.favoritesForm = favoritesForm;
    }
}
