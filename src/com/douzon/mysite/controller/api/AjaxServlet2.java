package com.douzon.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mysite.vo.UserVo;

import net.sf.json.JSONObject;

@WebServlet("/ajax2")
public class AjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");

		// java object -> json String 
		UserVo vo = new UserVo(); // 객체 생성
		// 생성된 객체에 값을 넣는다.
		vo.setNo(10);
		vo.setName("둘리");
		vo.setEmail("dooly@gmail.com");
		vo.setGender("male");
		
		JSONObject jsonObject = JSONObject.fromObject(vo);
		String jsonString = jsonObject.toString();  // 자바 객체를 json으로 변환해주는 작업

		PrintWriter pw = response.getWriter();
		pw.print(jsonString); // jsonString을  직접 입력
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
