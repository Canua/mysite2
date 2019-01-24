package com.douzon.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.GuestbookDao;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.GuestbookVo;
import com.douzon.mysite.vo.UserVo;

public class DeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");

		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);

		new GuestbookDao().delete(vo);

		WebUtils.redirect(request, response, request.getContextPath() + "/guestbook?a=list");

	}

}
