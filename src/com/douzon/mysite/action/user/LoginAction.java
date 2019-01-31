package com.douzon.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.UserVo;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserVo authUser = new UserDao().get(email, password);
		
		if(authUser == null) {
			// 인증 실패
			request.setAttribute("result", "fail");
			WebUtils.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return;
		}
		// 인증 성공 -> 인증 처리
		HttpSession session = 
				request.getSession(true); // 세션이 없다면 만들어서 달라 
		session.setAttribute("authuser", authUser);

		// 로그인 후 메인으로 이동
		// main redirect
		WebUtils.redirect(request, response, request.getContextPath());
	}

}
