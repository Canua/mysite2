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

public class ReplyAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long groupNo = Long.parseLong(request.getParameter("gno"));
		long orderNo = Long.parseLong(request.getParameter("ono"));
		long depth = Long.parseLong(request.getParameter("depth"));
		System.out.println(orderNo);
		
		UserVo authUser = null;

		HttpSession session = request.getSession();
		if (session != null) {
			authUser = (UserVo) session.getAttribute("authuser");
		}
		if (authUser == null) {
			WebUtils.redirect(request, response, request.getContextPath());
		}
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		long user_no = authUser.getNo();
	
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setG_no(groupNo);
		vo.setO_no(orderNo);
		vo.setDepth(depth);
		vo.setUser_no(user_no);
	
		BoardVo bo = new BoardVo();
		bo.setG_no(groupNo);
		bo.setO_no(orderNo);
		
		new BoardDao().replyUpdate(bo);
		new BoardDao().reply(vo);
		
		
		WebUtils.redirect(request, response, request.getContextPath() + "/board?a=&page=1");
		
	}

}
