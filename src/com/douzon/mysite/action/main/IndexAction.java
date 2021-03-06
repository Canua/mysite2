package com.douzon.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mvc.util.WebUtils;

public class IndexAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 쿠키 Test
		// 쿠키 읽기
		int count = 0;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if ("visitCount".equals(c.getName())) {
					count = Integer.parseInt(c.getValue());
					break;
				}
			}
		}
		// 쿠키 쓰기
		count++;
//		int count = 1;
		Cookie cookie = new Cookie("visitCount", "" + count);
		cookie.setMaxAge(24 * 60 * 60);
//		메모리에 남게 할 수 있다.
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);

		WebUtils.forward(request, response, "/WEB-INF/views/main/index.jsp");
	}

}
