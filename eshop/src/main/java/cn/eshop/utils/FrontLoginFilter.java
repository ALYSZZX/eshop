package cn.eshop.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.eshop.core.bean.UserInfo;

public class FrontLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UserInfo user =  (UserInfo) session.getAttribute("userInfo");
		
		String url = req.getRequestURI();
		
		if(!url.contains("/admin")){		
			chain.doFilter(request, response);
		}else if(url.contains("/admin")&&user!=null){
			chain.doFilter(request, response);
		}else{
			req.getRequestDispatcher("/WEB-INF/front_page/login.jsp").forward(request, response);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
