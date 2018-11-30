package com.wy.webtier;

import com.wy.domain.OrderDetailForm;
import com.wy.domain.OrderForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import com.wy.dao.OrderDao;
import com.wy.dao.OrderDetailDao;

import java.util.List;

/**
 * struts action of order
 */
public class OrderAction extends Action {
    private OrderDao order = null;
    private OrderDetailDao orderDetail = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) {
        int action = Integer.parseInt(request.getParameter("action"));
        order = new OrderDao();
        orderDetail = new OrderDetailDao();
        switch (action) {
            case 0: {
                return selectOrder(mapping, form, request, response);
            }
            case 1: {
                return selectOrderSend(mapping, form, request, response);
            }
            case 2: {
                return deleteOrder(mapping, form, request, response);
            }
            case 3: {
                return selectOneOrder(mapping, form, request, response);
            }

        }
        throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    /**
     * select one order
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOneOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) {
        String number = request.getParameter("number");
        OrderForm orderForm = order.selectOrderNumber(number);
        List<OrderDetailForm> orderDetailForms = orderDetail.selectOrderDetailNumber(number);
        request.setAttribute("orderForm", orderForm);
        request.setAttribute("orderDetailList", orderDetailForms);
        System.out.println(orderForm);
        return mapping.findForward("selectOneOrder");
    }

    /**
     * delete order
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward deleteOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) {
        String number = request.getParameter("number");
        orderDetail.deleteOrderDetail(number);
        boolean b = order.deleteOrder(number);
        if (!b) {
            System.out.println("delete failed");
        }
        return selectOrder(mapping, form, request, response);
    }

    /**
     * select order send
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOrderSend(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                         HttpServletResponse response) {
        order.updateSignOrder(request.getParameter("number"));
        return selectOrder(mapping, form, request, response);
    }

    /**
     * select order
     *
     * @param mapping  the action mapping
     * @param form     the action form
     * @param request  the request of http
     * @param response the response of http
     * @return the action forward
     */
    public ActionForward selectOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) {
        Integer sign = null;
        if (request.getParameter("sign") != null) {
            sign = Integer.valueOf(request.getParameter("sign"));
        }
        List<OrderForm> list = order.selectOrderSign(sign);
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
        return mapping.findForward("selectOrder");
    }
}
