package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.uc3m.g3.models.User;

public class UserRequestHandler implements RequestHandlerInterface {
	
	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in UserRequestHandler");
		request.setAttribute("users", findAllUsers(1));
		return "users.jsp";
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
	public List<User> findAllUsers(int page) {
		System.out.println("Iniciando findAllUsers");
		Client client = ClientBuilder.newClient();
		List<User> users = new ArrayList<User>();
		WebTarget webResource = client.target("http://localhost:13305").path("/api/users");
		
		users = webResource.request().accept("application/json").get(java.util.ArrayList.class);
		for(User user : users) {
			System.out.println(user.getName()+user.getSurename()+user.getId());
		}
		return users;
	}
}
