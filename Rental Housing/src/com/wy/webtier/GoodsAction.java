package com.wy.webtier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.wy.dao.GoodsDao;
import com.wy.dao.SmallTypeDao;
import com.wy.domain.GoodsForm;
import com.wy.tool.UploadFile;

//商品的Action
public class GoodsAction extends Action {
	private int action;

	private GoodsDao dao = null;

	private SmallTypeDao small = null;


	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("gb2312");
		this.dao = new GoodsDao();
		small = new SmallTypeDao();
		action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return goodSelect(mapping, form, request, response); // 全部查询小类别信息
		}
		case 1: {
			return goodForward(mapping, form, request, response); // 转向页面
		}
		case 2: {
			return selectSmallName(mapping, form, request, response); // 查询小类别的名称
		}
		case 3: {
			return saveGoods(mapping, form, request, response); // 把从页面中信息存储在bean中
		}

		case 5: {
			return selectOneGoods(mapping, form, request, response); // 查看商品的详细信息
		}
		case 6: {
			return deleteGoods(mapping, form, request, response); // delete商品信息
		}
		case 7: {
			return goodSelectMark(mapping, form, request, response); // 按special price商品信息查询
		}
		case 8: {
			return goodSelectSmall(mapping, form, request, response); // 按小类别商品信息查询
		}
		case 9: {
			return goodSelectBig(mapping, form, request, response); // Inquiry by large category commodity information
		}
		case 10: {
			return managerFreePirceForward(mapping, form, request, response); // 转向special price商品页面
		}
		case 11: {
			return managerFreePirce(mapping, form, request, response); // 设置special price价格
		}
		case 12: {
			return goodSelectBigHead(mapping, form, request, response); // Inquiry by large category commodity information商品和商品小类别的名称
		}
		case 13: {
			return goodSelectSmallHead(mapping, form, request, response); // 按小类别商品信息查询商品和商品小类别的名称
		}
		case 14: {
			return goodSelectNewHead(mapping, form, request, response); // 新品查询
		}
		case 15: {
			return goodSelectFreeHead(mapping, form, request, response); // special price商品
		}
		case 16: {
			return goodSelectOneHead(mapping, form, request, response); // 前台单独查询商品的信息
		}
		}

		throw new java.lang.UnsupportedOperationException("Method $execute() not yet implemented.");
	}

	// 前台单独查询商品的信息
	public ActionForward goodSelectOneHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("goodSelectOneHead");
	}

	// special price商品
	public ActionForward goodSelectFreeHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		String mark = request.getParameter("mark");
		list = dao.selectMark(Integer.valueOf(mark));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectFreeHead");
	}

	// 新品查询
	public ActionForward goodSelectNewHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		String mark = request.getParameter("mark");
		list = dao.selectMark(Integer.valueOf(mark));
		request.setAttribute("list", list);
		return mapping.findForward("goodSelectNewHead");
	}

	// 按小类别商品信息查询商品和商品小类别的名称
	public ActionForward goodSelectSmallHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectSmallHead");
	}

	// Inquiry by large category commodity information商品和商品小类别的名称
	public ActionForward goodSelectBigHead(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectBigHead");
	}

	// 设置special price价格
	public ActionForward managerFreePirce(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		GoodsForm goodsForm = (GoodsForm) form;
		String mark = request.getParameter("mark").trim();
		String id = request.getParameter("id").trim();
		if (mark.equals("0")) {
			goodsForm.setFreePrice(Float.valueOf("0"));
			goodsForm.setMark(Integer.valueOf("0"));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm);
			request.setAttribute("result", "deletespecial price成功！！");
		} else {
			String free = request.getParameter("free").trim();
			goodsForm.setFreePrice(Float.valueOf(free));
			goodsForm.setMark(Integer.valueOf(mark));
			goodsForm.setId(Integer.valueOf(id));
			dao.managerPrice(goodsForm);
			request.setAttribute("result", "设置special price成功！！");
		}

		return mapping.findForward("goodsOperation");
	}

	// 转向special price商品页面
	public ActionForward managerFreePirceForward(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("managerFreePirce");
	}

	// Inquiry by large category commodity information
	public ActionForward goodSelectBig(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectBig");
	}

	// 按小类别商品信息查询
	public ActionForward goodSelectSmall(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectSmall");
	}

	// 按special price商品信息查询
	public ActionForward goodSelectMark(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectMark(Integer.valueOf(request.getParameter("mark")));
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelectMark");
	}

	// delete商品的操作
	public ActionForward deleteGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("result", "delete商品信息成功");
		return mapping.findForward("goodsOperation");
	}

	// 查看商品的详细信息
	public ActionForward selectOneGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectContent");
	}

	// 添加商品的信息
	public ActionForward saveGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UploadFile uploadFile = new UploadFile();
		GoodsForm goodsForm = (GoodsForm) form;

		String dir = servlet.getServletContext().getRealPath("/goodsPicture");
		FormFile formFile = goodsForm.getFormFile();
		String getType = formFile.getFileName().substring(formFile.getFileName().lastIndexOf(".") + 1);
		String result = "add house failed";
		String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP" };
		for (int ii = 0; ii < imageType.length; ii++) {
			if (imageType[ii].equals(getType)) {

				goodsForm.setBig(Integer.valueOf(request.getParameter("big")));
				goodsForm.setSmall(Integer.valueOf(request.getParameter("small")));
				goodsForm.setName(request.getParameter("name"));
				goodsForm.setFrom(request.getParameter("from"));
				goodsForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
				goodsForm.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
				goodsForm.setIntroduce(request.getParameter("introduce"));

				goodsForm.setPriture("goodsPicture/" + uploadFile.upload(dir, formFile));
				dao.insertGoods(goodsForm);
				result = "add house successfully";
			}
		}
		request.setAttribute("result", result);
		return mapping.findForward("goodsOperation");
	}

	// 查询小类别的名称
	public ActionForward selectSmallName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("bigId", request.getParameter("bigId"));
		return mapping.findForward("goodForward");
	}

	// 转向页面
	public ActionForward goodForward(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return mapping.findForward("goodForward");
	}

	// 全部查询信息
	public ActionForward goodSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> list = null;
		list = dao.selectGoods();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
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
		return mapping.findForward("goodSelect");
	}
}
