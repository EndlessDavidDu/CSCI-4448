package com.wy.webtier;

import com.wy.domain.BigTypeForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;

import java.util.List;

import com.wy.dao.BigTypeDao;

/**
 * struts action of big type
 */
public class BigTypeAction extends Action {

    private BigTypeDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) {
        dao = new BigTypeDao();
        int action = Integer.parseInt(request.getParameter("action"));
        switch (action) {
            case 0: {
                return bigTypeSelect(mapping, form, request, response);
            }
            case 2: {
                return bigTypeInsert(mapping, form, request, response);
            }
            case 3: {
                return bigTypeDelete(mapping, form, request, response);
            }
        }

        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * big type delete
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward bigTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
            request.setAttribute("result", "delete big type successfully");
        } else {
            request.setAttribute("result", "please delete big type firstly");
        }

        return mapping.findForward("resultBigType");
    }

    /**
     * big type insert
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward bigTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        dao.insertBig(request.getParameter("name"));
        request.setAttribute("result", "add big type successfully");
        return mapping.findForward("resultBigType");
    }

    /**
     * big type select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward bigTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        List<BigTypeForm> list = dao.selectBig();
        int pageNumber = list.size();
        int maxPage = pageNumber;
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
        return mapping.findForward("bigTypeSelect");
    }

}
