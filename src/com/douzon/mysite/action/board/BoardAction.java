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

public class BoardAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		UserVo authUser = null;
//
//		HttpSession session = request.getSession();
//		authUser = (UserVo) session.getAttribute("authuser");
//
//		if (authUser != null) {
//			UserVo bo = new UserDao().get(authUser.getNo());
//			request.setAttribute("bo", bo);
//		}
//
//		BoardDao dao = new BoardDao();
//		List<BoardVo> list_set = dao.getList();
//		request.setAttribute("list_set", list_set);
//		int pageCreate = list_set.size()/5;
//		System.out.println(pageCreate);
//		request.setAttribute("pagecreate", pageCreate);
//
//		
//		List<BoardVo> list = dao.getPageList(0);
//		request.setAttribute("list",  list);
//		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
//	@Override
//	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		System.out.println("xxxxxxxxxxxxx");
//		int pageNum_set = Integer.parseInt(request.getParameter("page"));
//		BoardDao dao = new BoardDao();
//		List<BoardVo> list_set = dao.getList();
//
//		int pageCreate = list_set.size() / 5;
//
//		if (pageNum_set < 1) {
//			pageNum_set = 1;
//			System.out.println(pageNum_set);
//		}
//		if (pageNum_set > pageCreate + 1) {
//			pageNum_set = pageCreate + 1;
//		}
//
//		UserVo authUser = null;
//
//		HttpSession session = request.getSession();
//		authUser = (UserVo) session.getAttribute("authuser");
//
//		if (authUser != null) {
//			UserVo bo = new UserDao().get(authUser.getNo());
//			request.setAttribute("bo", bo);
//		}
//		request.setAttribute("list_set", list_set);
//
//		int pageNum = (pageNum_set - 1) * 5;
//		System.out.println("페이지 번호 : " + pageNum_set);
//		request.setAttribute("pagecreate", pageCreate);
//		request.setAttribute("pageNum_set", pageNum_set);
//		List<BoardVo> list = dao.getPageList(pageNum);
//		request.setAttribute("list", list);
//
//		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
//
	}

}
