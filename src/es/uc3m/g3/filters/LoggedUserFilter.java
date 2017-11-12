package es.uc3m.g3.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggedUserFilter
 */
@WebFilter(urlPatterns = {"/events","/users", "/conversations", "/eventdetail"})
public class LoggedUserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggedUserFilter() {
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
		System.out.println("Filtering if user is logged...");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(httpRequest.getSession().getAttribute("user")!=null){
			System.out.println("User was logged, forwarding to previous page");
			chain.doFilter(request, response);
		} else {
			System.out.println("No logged user, redirecting to login");
			System.out.println("Saved url:"+httpRequest.getServletPath()+httpRequest.getQueryString());
			httpRequest.getSession().setAttribute("from", httpRequest.getServletPath()+"?"+httpRequest.getQueryString());
			request.getRequestDispatcher("/login").forward(httpRequest, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
