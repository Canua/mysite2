package com.douzon.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.GuestbookDao;
import com.douzon.mysite.vo.GuestbookVo;

public class listAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();

		request.setAttribute("list", list);

		WebUtils.forward(request, response, "WEB-INF/views/guestbook/list.jsp");
	}

}
