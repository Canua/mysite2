package com.douzon.mysite.action.board;

import java.io.IOException;

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

public class BoardModifyAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long viewNo = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setNo(viewNo);
		vo.setTitle(title);
		vo.setContents(contents);
		System.out.println(vo.getNo());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContents());
		new BoardDao().update(vo);
		
		WebUtils.redirect(request, response, request.getContextPath() + "/board?a=view&no=" + viewNo);
		
	}

}
