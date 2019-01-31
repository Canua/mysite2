package com.douzon.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/")
public class EncodingFilter implements Filter {
	private String encoding;
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encoding Filter Initialized...");
		
		encoding = fConfig.getInitParameter("encoding");
		if(encoding == null) { // web.xml에서 설정 안했을 때를 대비해서
			encoding = "UTF-8";
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* request 처리 */
		request.setCharacterEncoding(encoding);
		// Servlet의 공통으로 처리해야 할 부분을 가져와서 처리할 수 있다.
		chain.doFilter(request, response);
	
		/* response 처리 */
	}

	public void destroy() {
	}

	public EncodingFilter() {
	}

}
