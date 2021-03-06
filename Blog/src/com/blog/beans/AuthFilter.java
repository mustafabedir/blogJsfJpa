package com.blog.beans;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 try {
	            HttpServletRequest req = (HttpServletRequest) request;
	            HttpServletResponse res = (HttpServletResponse) response;
	            HttpSession ses = req.getSession(false);
	            String reqURI = req.getRequestURI();
	            if ( reqURI.indexOf("/Login.xhtml") >= 0 || (ses != null)
	                                       || reqURI.indexOf("Admin") >= 0 || reqURI.contains("javax.faces.resource") )
	                   chain.doFilter(request, response);
	            else
	                   res.sendRedirect(req.getContextPath() + "/Login.xhtml"); 
	                   
	      }
	     catch(Throwable t) {
	         System.out.println( t.getMessage());
	     }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
