package com.douzon.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.vo.BoardVo;
import com.douzon.mysite.vo.UserVo;

public class BoardModifyFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserVo authUser = null;

		HttpSession session = request.getSession();
		if (session != null) {
			authUser = (UserVo) session.getAttribute("authuser");
		}
		if (authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath());
		}

		long viewNo = Long.parseLong(request.getParameter("no"));
		boolean check = new BoardDao().check(viewNo, authUser.getNo());
		if (check == true) {
			BoardVo vo = new BoardDao().getView(viewNo);
			request.setAttribute("vo", vo);
			WebUtils.forward(request, response, "/WEB-INF/views/board/modify.jsp");
		} else {
			WebUtils.redirect(request, response, request.getContextPath() + "board?a=&page=1");
		}
	
	}

}
