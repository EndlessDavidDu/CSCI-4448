package com.wy.domain;

import org.apache.struts.action.ActionForm;

/**
 * Member Form
 */
public class MemberForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Integer age ;

	private String email = "";

	private Integer id = 1;

	private String name = "";

	private String password = "";

	private String profession = "";

	private String question = ""; // The problem of retrieving passwords

	private String reallyName = "";

	private String result = ""; // Retrieve the password

	private int roleType = 0;//0 customer and 1 admin

	private MerchantForm merchantForm;

	public MerchantForm getMerchantForm() {
		return merchantForm;
	}

	public void setMerchantForm(MerchantForm merchantForm) {
		this.merchantForm = merchantForm;
	}

	public MemberForm() {
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setProfession(String profession) {
		this.profession = profession;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
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

	public String getProfession() {
		return profession;
	}

	public String getQuestion() {
		return question;
	}

	public String getReallyName() {
		return reallyName;
	}

	public String getResult() {
		return result;
	}
}
