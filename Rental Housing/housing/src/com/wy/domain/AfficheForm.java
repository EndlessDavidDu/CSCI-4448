package com.wy.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Affiche Form
 */
public class AfficheForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String content = "";
    private Integer id = -1;
    private String issueTime = "";
    private String name = "";


    public AfficheForm() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
    }
}
