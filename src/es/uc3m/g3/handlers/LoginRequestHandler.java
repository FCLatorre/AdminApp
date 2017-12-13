package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.uc3m.g3.models.User;

public class LoginRequestHandler implements RequestHandlerInterface {
	
	
	public LoginRequestHandler(){
		super();
	}
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
		User user = getUser(email, password);
		if(user!=null){
			System.out.println("LoginRequestHandler: login correct!");
			saveUserToSession(request, user);
			String newURL = (String) request.getSession().getAttribute("from");
			request.getSession().setAttribute("from", null);
			if(newURL==null){
				newURL="users";
			} else {
				request.getSession().setAttribute("redirected", true);
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

	private User getUser (String email, String password){
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:13305").path("/api/users")
				.queryParam("email", email)
				.queryParam("password", password);
		
		User user = webResource.request().accept("application/json").get(User.class);
		System.out.println("Returning value:"+ user.getEmail()+user.getPassword());
		return user;
	}

	private void saveUserToSession(HttpServletRequest request, User user){
		request.getSession().setAttribute("user", user);
	}

}
