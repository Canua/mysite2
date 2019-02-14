package com.douzon.mysite.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.Action;
import com.douzon.mysite.repository.UserDao;
import com.douzon.mysite.vo.UserVo;

import net.sf.json.JSONObject;

public class AjaxCheckEmailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		
		UserDao dao = new UserDao();
		UserVo vo = dao.get(email);
		
		boolean bExist = vo != null; // vo가 존재한다면
		Map<String, Object> map = new HashMap<String, Object>();// Object 
		map.put("exist", bExist);
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonString = jsonObject.toString();  // 자바 객체를 json으로 변환해주는 작업

		response.setContentType("application/json; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(jsonString); // jsonString을  직접 입력
	
	}
}
