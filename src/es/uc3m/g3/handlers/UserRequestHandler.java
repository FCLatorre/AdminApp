package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.UserBean;

public class UserRequestHandler extends RestrictedRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in LoginRequestHandler");
		UserBean user = new UserBean (request.getParameter("username"), request.getParameter("password"));
		if(super.checkRegisteredUser(request, user)){
			return "users.jsp";
		} else {
			return "login.jsp";
		}
		
	}
}
