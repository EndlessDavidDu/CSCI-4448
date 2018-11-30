package com.wy.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Link Form
 */
public class LinkForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private Integer id = -1;

    private String linkAddress = "";

    private String linkName = "";

    public LinkForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public String getLinkName() {
        return linkName;
    }

    @Override
    public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {

        return super.validate(arg0, arg1);
    }

}
