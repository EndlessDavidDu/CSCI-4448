package com.wy.domain;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class BullentinForm extends ActionForm{
    private static final long serialVersionUID = 1L;
    private String content = "";
    private Integer id = new Integer(-1);
    private String issueTime = "";
    private String name = "";
    private int merchantId;

    public BullentinForm(String content, Integer id, String issueTime, String name, int merchantId) {
        this.content = content;
        this.id = id;
        this.issueTime = issueTime;
        this.name = name;
        this.merchantId = merchantId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        /** @todo: finish this method, this is just the skeleton. */
        return null;
    }

    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
