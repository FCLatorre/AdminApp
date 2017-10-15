package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.UserBean;
import es.uc3m.g3.bean.EventBean;

public class EventsRequestHandler
    extends RestrictedRequestHandler implements RequestHandlerInterface {

  @Override
  public String handleGETRequest(HttpServletRequest request,
                              HttpServletResponse response) {
    System.out.println("Handling the request in EventsRequestHandler");
    UserBean user = new UserBean(request.getParameter("username"),
                                 request.getParameter("password"));
    if (super.checkRegisteredUser(request, user)) {
      request.setAttribute("events", getEvents());
      return "events.jsp";
    } else {
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

  private ArrayList<EventBean> getEvents() {
	    ArrayList<EventBean> events = new ArrayList<EventBean>();

	    Date date = new Date();

	    events.add(new EventBean("id001", "event1", "Description of event1", date,
	                             "UC3M", "hall1", "/images/image1.png", (short) 2, 6.25,
	                             "CATEGORY"));
	    events.add(new EventBean("id002", "event2", "Description of event2", date,
	                             "UC3M2", "hall2", "/images/image2.png", (short) 2, 6.25,
	                             "CATEGORY"));
	    events.add(new EventBean("id003", "event3", "Description of event3", date,
	                             "UC3M3", "hall3", "/images/image3.png", (short) 2, 6.25,
	                             "CATEGORY"));

	    return events;
	  }
}
