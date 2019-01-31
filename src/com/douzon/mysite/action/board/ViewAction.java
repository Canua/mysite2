package com.douzon.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.BoardDao;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.BoardVo;
import com.douzon.mysite.vo.UserVo;

public class ViewAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserVo authUser = null;

		HttpSession session = request.getSession();
		authUser = (UserVo) session.getAttribute("authuser");

		if (authUser != null) {
			UserVo bo = new UserDao().get(authUser.getNo());
			request.setAttribute("bo", bo);
		}
		long viewNo = Long.parseLong(request.getParameter("no"));
		new BoardDao().hitUpdate(viewNo);
		BoardVo vo = new BoardDao().getView(viewNo);
		
		request.setAttribute("vo", vo);

		WebUtils.forward(request, response, "/WEB-INF/views/board/view.jsp");

	}
}
