package com.wy.webtier;

import com.wy.syntheticDomain.MemberMerchantForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.wy.domain.MemberForm;
import org.apache.struts.action.Action;
import com.wy.dao.MemberDao;
import java.io.IOException;
import java.util.*;

//Member management Action
public class MemberAction extends Action {
	private int action;
	private MemberDao dao = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		dao = new MemberDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return insertMember(mapping, form, request, response); // 添加员工信息
		}
		case 1: {
			return checkMember(mapping, form, request, response); // 会员登录
		}
		case 2: {
			return selectMember(mapping, form, request, response); // 查看会员信息
		}
		case 3: {
			return selectOneMember(mapping, form, request, response); // 查看会员的详细信息
		}
		case 4: {
			return deleteMember(mapping, form, request, response); // delete会员信息
		}
		case 5: {
			return selectOneMemberHead(mapping, form, request, response); // 前台查询会员的属性
		}
		case 6: {
			return updateMemberHead(mapping, form, request, response); // 修改会员属性
		}

		}
		// MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 修改会员属性
	public ActionForward updateMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		MemberForm memberForm = (MemberForm) form;
		dao.updateMember( memberForm);
		request.setAttribute("success", "modify successfully ");
		return mapping.findForward("operationMember");
	}

	// The front desk queries members for attributes
	public ActionForward selectOneMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneMember(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectOneMemberHead");
	}

	// delete operation
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
			return mapping.findForward("deleteMember");
		}
		return selectMember(mapping, form, request, response);
	}

	// View member details
	public ActionForward selectOneMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
	}

	// View member information
	public ActionForward selectMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = dao.selectMember();
		int pageNumber = list.size(); // Figure out how many records there are
		int maxPage = pageNumber; // Count the number of pages
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("selectMember");
	}

	// 会员登录
	public ActionForward checkMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		MemberForm memberForm = dao.selectMemberForm(name);
		if (memberForm == null ) {
			request.setAttribute("result", "This member does not exist, please login again!!!");
		} else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
			request.setAttribute("result", "Password error, please login again!!!");
		} else {
			request.setAttribute("memberForm", memberForm);
		}
		return mapping.findForward("checkMember");
	}

	// 添加员工信息
	public ActionForward insertMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		MemberForm memberForm = (MemberForm) form;
		MemberForm formSelect = dao.selectMemberForm(memberForm.getName());
		if (formSelect == null ) {
			dao.insertMember(memberForm);
			request.setAttribute("success", "registered successfully ");
		} else {
			request.setAttribute("success", "This member name already exists!!!");
		}
		return mapping.findForward("operationMember");
	}
}
