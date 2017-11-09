package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import es.uc3m.g3.entities.Conversacion;
import es.uc3m.g3.entities.EntidadUsuario;


public class ConversationsRequestHandler implements RequestHandlerInterface {
	private EntityManager em;
	private UserTransaction ut;

	public ConversationsRequestHandler (EntityManager em, UserTransaction ut){
		this.em = em;
		this.ut = ut;
	}
	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in ConversationsRequestHandler");
		request.setAttribute("conversations", getConversations());
		return "conversations.jsp";
	}

	@Override
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ArrayList<Conversacion> getConversations (){
		Query query = em.createNamedQuery("Conversacion.findAll");
		List<Conversacion> conversations = query.getResultList();
		for(Conversacion conversation : conversations) {
			System.out.println(conversation.getEntidadAdministrador().getNombre()+conversation.getEntidadUsuario().getNombre());
		}
		return new ArrayList<Conversacion> (conversations);
	}

}
