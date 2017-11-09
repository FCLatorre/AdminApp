package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import es.uc3m.g3.entities.Evento;

public class EventsRequestHandler implements RequestHandlerInterface {
	private EntityManager em;
	private UserTransaction ut;

	public EventsRequestHandler (EntityManager em, UserTransaction ut){
		this.em = em;
		this.ut = ut;
	}
	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in EventsRequestHandler");
		request.setAttribute("events", getEvents());
		return "events.jsp";
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

  private ArrayList<Evento> getEvents() {
	    Query query = em.createNamedQuery("Evento.findAll");
		List<Evento> events = query.getResultList();
		/*for(Evento event : events) {
			System.out.println(conversation.getEntidadAdministrador().getNombre()+conversation.getEntidadUsuario().getNombre());
		}*/
		return new ArrayList<Evento> (events);
	  }
}
