package com.douzon.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;

public class searchAction implements Action {
	ServletRequest request;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String select = request.getParameter("select");
		String kwd = request.getParameter("kwd");

		if (kwd == null)
			kwd = "";
		kwd = kwd.replaceAll(" ", "");
		if (kwd.equals("")) {
			WebUtils.redirect(request, response, request.getContextPath() + "/board?a=&page=1");
			return;
		}

		int selectCount = 0;
		int pageNum_set = 1;
		int cancel = 9999;
		request.setAttribute("pageNum_set", pageNum_set);
		request.setAttribute("cancel", cancel);

		if (select.equals("all")) {
			selectCount = 1;
			Select(request, select, kwd, selectCount);
		} else if (select.equals("user")) {
			selectCount = 2;
			Select(request, select, kwd, selectCount);
		} else if (select.equals("title")) {
			selectCount = 3;
			Select(request, select, kwd, selectCount);
		}
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}

	public void Select(HttpServletRequest request, String select, String kwd, int selectCount) {
		BoardDao dao = new BoardDao();
		List<BoardVo> list_set = dao.select(kwd, selectCount);
		int pageCreate = list_set.size() / 5;
		request.setAttribute("list_set", list_set);
		request.setAttribute("pagecreate", pageCreate);
		List<BoardVo> list = dao.select(kwd, selectCount);
		request.setAttribute("list", list);
	}

}
