package com.wy.webtier;

import com.wy.dao.MemberDao;
import com.wy.domain.MemberForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * struts action of member
 */
public class MemberAction extends Action {
    private MemberDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        dao = new MemberDao();
        int action = Integer.parseInt(request.getParameter("action"));
        switch (action) {
            case 0: {
                return insertMember(mapping, form, request, response);
            }
            case 1: {
                return checkMember(mapping, form, request, response);
            }
            case 2: {
                return selectMember(mapping, form, request, response);
            }
            case 3: {
                return selectOneMember(mapping, form, request, response);
            }
            case 4: {
                return deleteMember(mapping, form, request, response);
            }
            case 5: {
                return selectOneMemberHead(mapping, form, request, response);
            }
            case 6: {
                return updateMemberHead(mapping, form, request, response);
            }

        }
        // MemberForm memberForm = (MemberForm) form;
        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * update member head
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward updateMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                          HttpServletResponse response) {
        MemberForm memberForm = (MemberForm) form;
        dao.updateMember(memberForm);
        request.setAttribute("success", "modify successfully ");
        return mapping.findForward("operationMember");
    }

    /**
     * select one member head
     * The front desk queries members for attributes
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOneMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                             HttpServletResponse response) {
        request.setAttribute("form", dao.selectOneMember(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("selectOneMemberHead");
    }

    /**
     * delete member
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
            return mapping.findForward("deleteMember");
        }
        return selectMember(mapping, form, request, response);
    }

    /**
     * select one member
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOneMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("form", dao.selectOneMember(id));
        return mapping.findForward("selectOneMember");
    }

    /**
     * select members
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
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

    /**
     * check member
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward checkMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) {
        String name = request.getParameter("name");
        MemberForm memberForm = dao.selectMemberForm(name);
        if (memberForm == null) {
            request.setAttribute("result", "This member does not exist, please login again!!!");
        } else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
            request.setAttribute("result", "Password error, please login again!!!");
        } else {
            request.setAttribute("memberForm", memberForm);
            request.getSession().setAttribute("memberForm", memberForm);

        }
        return mapping.findForward("checkMember");
    }

    /**
     * insert member
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward insertMember(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) {
        MemberForm memberForm = (MemberForm) form;
        MemberForm formSelect = dao.selectMemberForm(memberForm.getName());
        if (formSelect == null) {
            dao.insertMember(memberForm);
            request.setAttribute("success", "Registered successfully ");
        } else {
            request.setAttribute("success", "This member name already exists!!!");
        }

        return mapping.findForward("operationMember");
    }
}
