package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.g3.bean.UserBean;

public class LoginRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in LoginRequestHandler");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email == null || password== null) {
			System.out.println("LoginRequestHandler: no parameters");
			return "login.jsp";
		}
		
		if(checkLogin(email, password)){
			System.out.println("LoginRequestHandler: login correct!");
			saveUserToSession(request, email, password);
			return "users.jsp";
		}else{
			System.out.println("LoginRequestHandler: login incorrect!");
			request.setAttribute("nologin", "Usuario y contraseña incorrecta!");
			return "login.jsp";
		}
	}
	
	private boolean checkLogin (String email, String password){
		UserBean user = new UserBean("admin@admin.com", "admin");
		return user.getEmail().equals(email) && user.getPassword().equals(password);
	}
	
	private void saveUserToSession(HttpServletRequest request, String email, String password){
		HttpSession session = request.getSession();
		session.setAttribute("user", new UserBean(email, password));
	}

}
