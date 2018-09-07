package com.campusnumerique.vehiclerental.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.bean.ClientBean;

import sun.rmi.server.Dispatcher;

/**
 * Servlet Filter implementation class AgentFilter
 */

public class AgentFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AgentFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		ClientBean clientBean = new ClientBean();
		HttpServletRequest req = (HttpServletRequest) request;
		RequestDispatcher rd = req.getServletContext().getNamedDispatcher("home_VUE");

		if (req.getSession().getAttribute("clientBean") != null) {
			clientBean = (ClientBean) req.getSession().getAttribute("clientBean");
		}

		String servletPath = req.getServletPath();

		if ((servletPath.contains("/reservationManage")|| servletPath.contains("/clients")) && !clientBean.getRole().equals("agent")) {
			req.setAttribute("AccessDenied", "Access denied");
			rd.forward(req, response);
			return;


		} else if ((servletPath.contains("/reservation") || servletPath.contains("/validation") )&& clientBean.isGuest()) {
			req.setAttribute("AccessDenied", "Access denied");
			rd.forward(req, response);
			return;

		} else {

			chain.doFilter(request, response);
			return;

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
