package com.wy.webtier;

import org.apache.struts.action.*;

import javax.servlet.http.*;

import com.wy.domain.ManagerForm;
import com.wy.dao.ManagerDao;

import java.util.*;

/**
 * struts action of big type
 */
public class ManagerAction extends Action {
    private ManagerDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        dao = new ManagerDao();
        int action = Integer.parseInt(request.getParameter("action"));
        switch (action) {
            case 0: {
                return managerCheck(mapping, form, request, response);
            }
            case 1: {
                return managerSelect(mapping, form, request, response);
            }
            case 3: {
                return managerInsert(mapping, form, request, response);
            }
            case 4: {
                return managerDelete(mapping, form, request, response);
            }
            case 8: {
                return managerUpdatePassword(mapping, form, request, response);
            }
        }
        throw new java.lang.UnsupportedOperationException(
                "Method $execute() not yet implemented.");
    }

    /**
     * manager update password
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward managerUpdatePassword(ActionMapping mapping,
                                               ActionForm form,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        ManagerForm managerForm = (ManagerForm) form;
        managerForm.setAccount(request.getParameter("account"));
        managerForm.setPassword(request.getParameter("password"));
        dao.updateManagerPassword(managerForm);
        request.setAttribute("result", "modify successfully, please re-login!");
        return mapping.findForward("managerUpdatePassword");
    }

    /**
     * manager delete
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward managerDelete(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        dao.deleteManager(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("result", "delete successfully!");
        return managerSelect(mapping, form, request, response);
    }

    /**
     * manager insert
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward managerInsert(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        ManagerForm managerForm = (ManagerForm) form;

        ManagerForm manager = dao.selectOne(managerForm.getAccount());
        if (manager == null) {
            dao.insertManager(managerForm);
            return managerSelect(mapping, form, request, response);
        } else {
            request.setAttribute("result", "the user exists already!");
            return mapping.findForward("managerInsert");
        }
    }

    /**
     * manager select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward managerSelect(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        List<ManagerForm> list = dao.selectManager();
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if (maxPage % 7 == 0) {
            maxPage = maxPage / 7;
        } else {
            maxPage = maxPage / 7 + 1;
        }
        if (number == null) {
            number = "0";
        }
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));

        request.setAttribute("list", list);
        return mapping.findForward("managerSelect");
    }

    /**
     * manager check
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward managerCheck(ActionMapping mapping,
                                      ActionForm form,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        String account = request.getParameter("account");
        ManagerForm managerForm = dao.selectOne(account);
        if (managerForm == null) {
            request.setAttribute("result", "the account doesn't exist");
            return mapping.findForward("checkResult");
        } else if (!managerForm.getPassword().equals(request.getParameter("password"))) {
            request.setAttribute("result", "the password is wrong");
            return mapping.findForward("checkResult");
        } else {
            request.setAttribute("manager", managerForm);
            return mapping.findForward("checkResult");
        }
    }
}
