package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.g3.bean.UserBean;

public class LoginRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in LoginRequestHandler");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email == null || password== null) {
			System.out.println("LoginRequestHandler: no parameters");
			request.setAttribute("nologin", "No parameters where received");
			return "login.jsp";
		}

		if(checkLogin(email, password)){
			System.out.println("LoginRequestHandler: login correct!");
			saveUserToSession(request, email, password);
			String newURL = (String) request.getSession().getAttribute("from");
			request.getSession().setAttribute("from", null);
			if(newURL==null){
				newURL="users";
			}
			return newURL;
		}else{
			System.out.println("LoginRequestHandler: login incorrect!");
			request.setAttribute("nologin", "Incorrect username or password");
			return "login.jsp";
		}
	}
	@Override
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}
	@Override
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}
	@Override
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
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
