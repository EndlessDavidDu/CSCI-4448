package com.wy.webtier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.wy.dao.HouseDao;
import com.wy.dao.SmallTypeDao;
import com.wy.domain.HouseForm;
import com.wy.tool.UploadFile;

/**
 * struts action of house
 */
public class HouseAction extends Action {

    private HouseDao dao = null;

    private SmallTypeDao small = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        this.dao = new HouseDao();
        small = new SmallTypeDao();
        int action = Integer.parseInt(request.getParameter("action"));
        switch (action) {
            case 0: {
                return houseSelect(mapping, form, request, response);
            }
            case 1: {
                return houseForward(mapping, form, request, response);
            }
            case 2: {
                return selectSmallName(mapping, form, request, response);
            }
            case 3: {
                return saveHouse(mapping, form, request, response);
            }
            case 5: {
                return selectOneHouse(mapping, form, request, response);
            }
            case 6: {
                return deleteHouse(mapping, form, request, response);
            }
            case 7: {
                return houseSelectMark(mapping, form, request, response);
            }
            case 8: {
                return houseSelectSmall(mapping, form, request, response);
            }
            case 9: {
                return houseSelectBig(mapping, form, request, response);
            }
            case 10: {
                return manageFreePirceForward(mapping, form, request, response);
            }
            case 11: {
                return manageFreePirce(mapping, form, request, response);
            }
            case 12: {
                return houseSelectBigHead(mapping, form, request, response);
            }
            case 13: {
                return houseSelectSmallHead(mapping, form, request, response);
            }
            case 14: {
                return houseSelectNewHead(mapping, form, request, response);
            }
            case 15: {
                return houseSelectFreeHead(mapping, form, request, response);
            }
            case 16: {
                return houseSelectOneHead(mapping, form, request, response);
            }
        }

        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
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
    public ActionForward houseSelectOneHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) {
        request.setAttribute("form", dao.selectOneHouse(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("houseSelectOneHead");
    }

    /**
     * house select free head
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectFreeHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                             HttpServletResponse response) {
        String mark = request.getParameter("mark");
        List<HouseForm> list = dao.selectMark(Integer.valueOf(mark));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if (maxPage % 4 == 0) {
            maxPage = maxPage / 4;
        } else {
            maxPage = maxPage / 4 + 1;
        }
        if (number == null) {
            number = "0";
        }
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        return mapping.findForward("houseSelectFreeHead");
    }

    /**
     * house select free new head
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectNewHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) {
        String mark = request.getParameter("mark");
        List<HouseForm> list = dao.selectMark(Integer.valueOf(mark));
        request.setAttribute("list", list);
        return mapping.findForward("houseSelectNewHead");
    }

    /**
     * house select small head
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectSmallHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                              HttpServletResponse response) {
        List<HouseForm> list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if (maxPage % 4 == 0) {
            maxPage = maxPage / 4;
        } else {
            maxPage = maxPage / 4 + 1;
        }
        if (number == null) {
            number = "0";
        }
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        request.setAttribute("smallList", small.selectOneBigId(Integer.valueOf(request.getParameter("big"))));
        return mapping.findForward("houseSelectSmallHead");
    }

    /**
     * house select big head
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectBigHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) {
        List<HouseForm> list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if (maxPage % 4 == 0) {
            maxPage = maxPage / 4;
        } else {
            maxPage = maxPage / 4 + 1;
        }
        if (number == null) {
            number = "0";
        }
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        request.setAttribute("smallList", small.selectOneBigId(Integer.valueOf(request.getParameter("big"))));
        return mapping.findForward("houseSelectBigHead");
    }

    /**
     * manage free price
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward manageFreePirce(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        HouseForm houseForm = (HouseForm) form;
        String mark = request.getParameter("mark").trim();
        String id = request.getParameter("id").trim();
        if (mark.equals("0")) {
            houseForm.setFreePrice(Float.valueOf("0"));
            houseForm.setMark(Integer.valueOf("0"));
            houseForm.setId(Integer.valueOf(id));
            dao.managerPrice(houseForm);
            request.setAttribute("result", "deletespecial price successfully£¡£¡");
        } else {
            String free = request.getParameter("free").trim();
            houseForm.setFreePrice(Float.valueOf(free));
            houseForm.setMark(Integer.valueOf(mark));
            houseForm.setId(Integer.valueOf(id));
            dao.managerPrice(houseForm);
            request.setAttribute("result", "set special price successfully£¡£¡");
        }

        return mapping.findForward("houseOperation");
    }

    /**
     * manage free price forward
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward manageFreePirceForward(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                HttpServletResponse response) {
        request.setAttribute("form", dao.selectOneHouse(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("manageFreePirce");
    }

    /**
     * house select big
     * Inquiry by large category commodity information
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectBig(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) {
        List<HouseForm> list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
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
        return mapping.findForward("houseSelectBig");
    }

    /**
     * house select small
     * Inquiry by small category commodity information
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectSmall(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                          HttpServletResponse response) {
        List<HouseForm> list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
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
        return mapping.findForward("houseSelectSmall");
    }

    /**
     * house select mark
     * Inquiry by mark category commodity information
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelectMark(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        List<HouseForm> list = dao.selectMark(Integer.valueOf(request.getParameter("mark")));
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
        return mapping.findForward("houseSelectMark");
    }

    /**
     * delete house
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward deleteHouse(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) {
        dao.deleteHouse(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("result", "delete successfully");
        return mapping.findForward("houseOperation");
    }

    /**
     * select one house
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOneHouse(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) {
        request.setAttribute("form", dao.selectOneHouse(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("selectContent");
    }

    /**
     * save house
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward saveHouse(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        UploadFile uploadFile = new UploadFile();
        HouseForm houseForm = (HouseForm) form;
        String dir = servlet.getServletContext().getRealPath("/housePicture");
        FormFile formFile = houseForm.getFormFile();
        String getType = formFile.getFileName().substring(formFile.getFileName().lastIndexOf(".") + 1);
        String result = "add house failed( only support jpg/gif/bmp )";
        String imageType[] = {"jpg", "gif", "bmp"};
        for (String anImageType : imageType) {
            if (anImageType.equalsIgnoreCase(getType)) {
                houseForm.setBig(Integer.valueOf(request.getParameter("big")));
                houseForm.setSmall(Integer.valueOf(request.getParameter("small")));
                houseForm.setName(request.getParameter("name"));
                houseForm.setFrom(request.getParameter("from"));
                houseForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
                houseForm.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
                houseForm.setIntroduce(request.getParameter("introduce"));
                houseForm.setPicture("housePicture/" + uploadFile.upload(dir, formFile));
                dao.insertHouse(houseForm);
                result = "add house successfully";
                break;
            }
        }
        request.setAttribute("result", result);
        return mapping.findForward("houseOperation");
    }

    /**
     * select small name
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectSmallName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        request.setAttribute("bigId", request.getParameter("bigId"));
        return mapping.findForward("houseForward");
    }

    /**
     * house forward
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseForward(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) {
        return mapping.findForward("houseForward");
    }

    /**
     * house select
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward houseSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) {
        List<HouseForm> list = dao.selectHouse();
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
        return mapping.findForward("houseSelect");
    }
}
