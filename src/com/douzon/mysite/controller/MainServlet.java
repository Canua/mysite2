package com.douzon.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;
import com.douzon.mysite.action.main.MainActionFactory;

//@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter("a");

		AbstractActionFactory af = new MainActionFactory();
		Action action = af.getAction(actionName);
		action.excute(request, response);
	}

	@Override
	public void init() throws ServletException {
		String configParh = 
				this.getServletConfig().getInitParameter("config");
		
		System.out.println("init() called" + configParh);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
