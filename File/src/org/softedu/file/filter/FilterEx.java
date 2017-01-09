package org.softedu.file.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class FilterEx implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

			HttpServletRequest httpreq = (HttpServletRequest) request;
			HttpServletResponse httpresp = (HttpServletResponse) response;

			int n1 = httpreq.getServletPath().indexOf("login.jsp");
			int n2 = httpreq.getServletPath().indexOf("/servlet/Login");
			if (n1 != -1 || n2 != -1)       
			chain.doFilter(request, response);
			else 
			{
			HttpSession session = httpreq.getSession();
			String username = (String) session.getAttribute("username");
			if (username == null)
			httpresp.sendRedirect("/filter/login.jsp");
			}
			}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
