package com.douzon.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.vo.UserVo;

public class LogoutAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();

		if (session != null && session.getAttribute("authuser") != null) {
			// logout 처리
			session.removeAttribute("authuser");
			session.invalidate();
		}
		// session 유저를 없애라
		WebUtils.redirect(request, response, request.getContextPath());
	}

}
