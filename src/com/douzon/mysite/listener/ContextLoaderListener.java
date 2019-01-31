package com.douzon.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class ContextLoaderListener implements ServletContextListener {

	public ContextLoaderListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String contextConfigLocation = 
				servletContextEvent.getServletContext().getInitParameter("contextConfigLocation"); // 어플리케이션 정보를 가지고 있는 Container
		System.out.println("Container Starts...." + contextConfigLocation);
	}
}
