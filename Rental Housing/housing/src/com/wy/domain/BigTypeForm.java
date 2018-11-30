package com.wy.domain;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * Big Type Form
 */
public class BigTypeForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String bigName = "";
	private String creaTime = "";
	private Integer id = Integer.valueOf("-1");

	public BigTypeForm() {
	}

	public String getBigName() {
		return bigName;
	}

	public void setBigName(String bigName) {
		this.bigName = bigName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreaTime(String creaTime) {
		this.creaTime = creaTime;
	}

	public String getCreaTime() {
		return creaTime;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
		return null;
	}

	@Override
	public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
	}
}
