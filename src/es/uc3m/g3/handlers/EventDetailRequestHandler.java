package es.uc3m.g3.handlers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.g3.models.Category;
import es.uc3m.g3.models.Event;

public class EventDetailRequestHandler implements RequestHandlerInterface {
	private EntityManager em;
	private UserTransaction ut;

	public EventDetailRequestHandler (EntityManager em, UserTransaction ut){
		this.em = em;
		this.ut = ut;
	}
  @Override
  public String handleGETRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    System.out.println("Handling the request in EventDetailGETRequestHandler");
    int id = Integer.parseInt((String)request.getParameter("id"));
    request.setAttribute("event", getEventById(id));
    return "eventdetail.jsp";
  }

  @Override
  public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {
    /*System.out.println("Handling the request in EventDetailPOSTRequestHandler");
    Evento newEvent = new Evento();
    newEvent.setId(Integer.parseInt(request.getParameter("id")));
    newEvent.setTitulo(request.getParameter("eventName"));
    newEvent.setDescripcion(request.getParameter("description"));

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    try {
    	newEvent.setFecha(dateFormat.parse(request.getParameter("date")));
    } catch (ParseException e) {
    	newEvent.setFecha(new Date());
    	e.printStackTrace();
    }
    newEvent.setLocalizacion(request.getParameter("location"));
    newEvent.setSala(request.getParameter("hall"));
    
    //newEvent.setImagen(request.getParameter("img"));

    newEvent.setPrecio(new BigDecimal(request.getParameter("price")));
    newEvent.setNumeroEntradas(Short.parseShort(request.getParameter("tickets")));

    //find categoria o crearla
    String category = (String)request.getParameter("category");
    Categoria categoriaBean = em.find(Categoria.class, category);
    if(categoriaBean == null){
    	categoriaBean = new Categoria();
    	categoriaBean.setNombre(category);
    	//persistir nueva categoria?
    }
    newEvent.setCategoriaBean(categoriaBean);    

    em.persist(newEvent);

    request.setAttribute("id", newEvent.getId());
    System.out.println("Updating event: " + newEvent.getId());

    return "eventdetail?id=" + newEvent.getId();
    */return null;
  }

  @Override
  public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
    return handleGETRequest(request, response);
  }

  @Override
  public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {
    /*System.out.println("Handling the request in EventDetailDELETERequestHandler");
    int id = Integer.parseInt((String)request.getParameter("id"));
    Evento event = getEventById(id);
    System.out.println("Event:" + event);
    try {
	    System.out.println("Objects:" + em +ut);
		//this.ut.begin();
	    this.em.getTransaction().begin();
			this.em.remove(event);
		this.em.getTransaction().commit();
	    //this.ut.commit();
	    System.out.println("Deleting event" + id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
	    System.out.println("Can't delete event with id:" + id);
		e.printStackTrace();
	}
    

    return "events";*/return null;
  }

  private Event getEventById(int id) {
    //return em.find(Evento.class, id);
	  return null;
  }
}
