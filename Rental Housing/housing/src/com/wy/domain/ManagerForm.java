package com.wy.domain;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Manager Form
 */
public class ManagerForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String account = "";
    private Integer id = -1;
    private String name = "";
    private String password = "";
    private Integer sign = -1;

    public ManagerForm() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getSign() {
        return sign;
    }

    @Override
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
