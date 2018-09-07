package com.campusnumerique.vehiclerental.filters;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.log.Log;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(LogFilter.class.getName());
	
    /**
     * Default constructor. 
     */
    public LogFilter() {
        LOG.log(Level.INFO,"#################### LogFilter Init");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.log(Level.INFO,"#################### LogFilter Destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 	HttpServletRequest req = (HttpServletRequest) request;
		 
	        String servletPath = req.getServletPath();
		
	        LOG.log(Level.INFO,"#################### LogFilter : " + new Date() + " - ServletPath :" + servletPath +", URL =" + req.getRequestURL());
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
