package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		UserBean user = new UserBean("tiw", "123456");
		
		if(user.getUsername().equals(name) && user.getPassword().equals(password)){
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "home";
		}else{
			request.setAttribute("nologin", "Usuario y contraseña incorrecta!");
			return "index.jsp";
		}*/
		System.out.println("Handling the request in LoginRequestHandler");
		return "login.jsp";
	}

}
