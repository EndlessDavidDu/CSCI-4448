package com.wy.syntheticDomain;

import org.apache.struts.action.ActionForm;
import com.wy.domain.MemberForm;
import com.wy.domain.MerchantForm;

public class MemberMerchantForm extends ActionForm {

    private MemberForm memberForm;
    private MerchantForm merchantForm;

    public MemberMerchantForm(MemberForm memberForm) {
        this.memberForm = memberForm;
    }

    public MemberMerchantForm(MerchantForm merchantForm) {
        this.merchantForm = merchantForm;
    }

    public MemberForm getMemberForm() {
        return memberForm;
    }

    public void setMemberForm(MemberForm memberForm) {
        this.memberForm = memberForm;
    }

    public MerchantForm getMerchantForm() {
        return merchantForm;
    }

    public void setMerchantForm(MerchantForm merchantForm) {
        this.merchantForm = merchantForm;
    }
}
