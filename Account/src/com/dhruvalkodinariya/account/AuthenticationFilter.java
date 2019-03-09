package com.dhruvalkodinariya.account;

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

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
        	HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            HttpSession session = req.getSession(false);
            
            String path = ((HttpServletRequest) request).getServletPath();
            if (session == null) {
            	if(path.equals("/Login.jsp") || path.equals("/UserHome.jsp") || path.equals("/Logout.jsp") || path.equals("/LoginValidate")) {
        			chain.doFilter(request, response);
        		}
            	else if(path.startsWith("/css/")||path.startsWith("/image/")||path.startsWith("/js/")){
            		chain.doFilter(request, response);
            	}
            	else {
        			res.sendError(401, "Unauthorized access request");
        		}
            } else {
                chain.doFilter(request, response);
            }
        
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
