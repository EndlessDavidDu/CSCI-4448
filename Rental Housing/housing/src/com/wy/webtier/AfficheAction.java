package com.wy.webtier;

import org.apache.struts.action.*;

import javax.servlet.http.*;

import com.wy.domain.AfficheForm;
import com.wy.dao.AfficheDao;

import java.util.List;

/**
 * struts action of affiche
 */
public class AfficheAction extends Action {
    private AfficheDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) {
        dao = new AfficheDao();
        int action = Integer.parseInt(request.getParameter("action"));
        switch (action) {
            case 0: {
                return afficheSelect(mapping, form, request, response);
            }
            case 2: {
                return afficheInsert(mapping, form, request, response);
            }
            case 3: {
                return afficheDelete(mapping, form, request, response);
            }
            case 4: {
                return afficheSelectOne(mapping, form, request, response);
            }
            case 5: {
                return afficheUpdate(mapping, form, request, response);
            }
            case 6: {
                return afficheContent(mapping, form, request, response);
            }
        }
        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * affiche Content
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheContent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) {
        request.setAttribute("affiche", dao.selectOneAffiche(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("afficheContent");
    }

    /**
     * affiche select one
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                          HttpServletResponse response) {
        request.setAttribute("affiche", dao.selectOneAffiche(Integer.valueOf(request.getParameter("id"))));

        return mapping.findForward("afficheSelectOne");
    }

    /**
     * affiche update
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        AfficheForm afficheForm = (AfficheForm) form;
        dao.updateAffiche(afficheForm);
        return afficheSelect(mapping, form, request, response);
    }

    /**
     * affiche select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        List<AfficheForm> list = dao.selectAffiche();
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
        return mapping.findForward("afficheSelect");
    }

    /**
     * affiche insert
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        AfficheForm afficheForm = (AfficheForm) form;
        dao.insertAffiche(afficheForm);
        return afficheSelect(mapping, form, request, response);
    }

    /**
     * affiche delete
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward afficheDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) {
        dao.deleteAffiche(Integer.valueOf(request.getParameter("id")));
        return afficheSelect(mapping, form, request, response);
    }

}
