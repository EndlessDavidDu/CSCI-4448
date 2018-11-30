package com.wy.webtier;

import com.wy.dao.SmallTypeDao;
import com.wy.domain.SmallTypeForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * struts action of small type
 */
public class SmallTypeAction extends Action {
    private SmallTypeDao dao = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) {
        int action = Integer.parseInt(request.getParameter("action"));
        dao = new SmallTypeDao();
        switch (action) {
            case 0: {
                return smallTypeSelect(mapping, form, request, response);
            }
            case 2: {
                return smallTypeInsert(mapping, form, request, response);
            }
            case 3: {
                return smallTypeDelete(mapping, form, request, response);
            }
            case 4: {
                return smallTypeSelectOne(mapping, form, request, response);
            }
            case 5: {
                return smallTypeUpdate(mapping, form, request, response);
            }
            case 6: {
                return smallTypeSelectBigId(mapping, form, request, response);
            }
        }

        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * small type select big id
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeSelectBigId(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                              HttpServletResponse response) {
        List<SmallTypeForm> list = dao.selectOneBigId(Integer.valueOf(request.getParameter("bigId")));
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
        return mapping.findForward("smallTypeSelect");
    }

    /**
     * small type update
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        SmallTypeForm smallTypeForm = (SmallTypeForm) form;
        smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
        smallTypeForm.setId(Integer.valueOf(request.getParameter("id")));
        smallTypeForm.setSmallName(request.getParameter("name"));
        dao.updateSmall(smallTypeForm);
        request.setAttribute("success", "modify successfully");
        return mapping.findForward("smallTypeOperation");
    }

    /**
     * small type select one
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) {
        request.setAttribute("small", dao.selectOneBig(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("smallTypeSelectOne");
    }

    /**
     * small type delete
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {

        if (dao.deleteSmall(Integer.valueOf(request.getParameter("id")))) {
            request.setAttribute("result", "delete successfully");
        } else {
            request.setAttribute("result", "please delete firstly");
        }
        return mapping.findForward("smallTypeOperation");
    }

    /**
     * small type insert
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        SmallTypeForm smallTypeForm = (SmallTypeForm) form;
        smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
        smallTypeForm.setSmallName(request.getParameter("name"));
        dao.insertSmall(smallTypeForm);
        request.setAttribute("result", "add successfully");
        return mapping.findForward("smallTypeOperation");
    }

    /**
     * small type select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward smallTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        List<SmallTypeForm> list = dao.selectSmall();
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
        return mapping.findForward("smallTypeSelect");
    }
}
