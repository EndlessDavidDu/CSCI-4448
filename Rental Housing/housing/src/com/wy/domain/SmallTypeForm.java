package com.wy.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Small Type Form
 */
public class SmallTypeForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer bigId = Integer.valueOf("-1");
    private String createTime = "";
    private Integer id = Integer.valueOf("-1");
    private String smallName = "";

    public Integer getBigId() {
        return bigId;
    }

    public void setBigId(Integer bigId) {
        this.bigId = bigId;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getSmallName() {
        return smallName;
    }

    @Override
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
