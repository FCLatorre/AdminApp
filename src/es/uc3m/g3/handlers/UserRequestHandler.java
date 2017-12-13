package es.uc3m.g3.handlers;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.g3.models.EntidadUsuario;

public class UserRequestHandler implements RequestHandlerInterface {
	private EntityManager em;
	private UserTransaction ut;

	public UserRequestHandler (EntityManager em, UserTransaction ut){
		this.em = em;
		this.ut = ut;
	}
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
	public List<EntidadUsuario> findAllUsers(int page) {
		System.out.println("Iniciando findAllUsers");
		System.out.println("Entity Manager:" + em);
		Query query = em.createNamedQuery("EntidadUsuario.findAll");
		List<EntidadUsuario> users = query.getResultList();
		for(EntidadUsuario user : users) {
			System.out.println(user.getNombre()+user.getApellidos()+user.getId());
		}
		return users;
	}
}
