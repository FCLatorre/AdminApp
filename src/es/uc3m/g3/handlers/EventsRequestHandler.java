package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.uc3m.g3.models.Event;

public class EventsRequestHandler implements RequestHandlerInterface {
  
  @Override
  public String handleGETRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    System.out.println("Handling the request in EventsRequestHandler");
    request.setAttribute("events", getEvents());
    return "events.jsp";
  }

  @Override
  public String handlePOSTRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
    return handleGETRequest(request, response);
  }
  @Override
  public String handlePUTRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    return handleGETRequest(request, response);
  }
  @Override
  public String handleDELETERequest(HttpServletRequest request,
                                    HttpServletResponse response) {
    return handleGETRequest(request, response);
  }

  private List<Event> getEvents() {
	Client client = ClientBuilder.newClient();
	List<Event> events = new ArrayList<Event>();
	WebTarget webResource = client.target("http://localhost:13305").path("/api/events");
	events = webResource.request().accept("application/json").get(java.util.ArrayList.class);
	return events;
  }
}
