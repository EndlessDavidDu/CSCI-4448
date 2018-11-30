package com.wy.webtier;

import javax.servlet.http.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wy.domain.LinkForm;

import com.wy.dao.LinkDao;

import java.util.*;
import java.io.UnsupportedEncodingException;

/**
 * struts action of link
 */
public class LinkAction extends Action {
    private LinkDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws UnsupportedEncodingException {
        int action = Integer.parseInt(request.getParameter("action"));
        dao = new LinkDao();
        switch (action) {
            case 0: {
                return linkSelect(mapping, form, request, response);
            }
            case 2: {
                return linkInsert(mapping, form, request, response);
            }
            case 4: {
                return linkDelete(mapping, form, request, response);
            }
        }
        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * link delete
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward linkDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) {
        dao.deleteLink(Integer.valueOf(request.getParameter("id")));
        return linkSelect(mapping, form, request, response);
    }

    /**
     * link insert
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward linkInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) {
        LinkForm linkForm = (LinkForm) form;
        dao.insertLink(linkForm);
        return linkSelect(mapping, form, request, response);
    }

    /**
     * link select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward linkSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) {
        List<LinkForm> list = dao.selectLink();
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
        return mapping.findForward("linkSelect");
    }

}
