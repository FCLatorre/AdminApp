package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.UserBean;

public class EventsRequestHandler
    extends RestrictedRequestHandler implements RequestHandlerInterface {

  @Override
  public String handleRequest(HttpServletRequest request,
                              HttpServletResponse response) {
    System.out.println("Handling the request in LoginRequestHandler");
    UserBean user = new UserBean(request.getParameter("username"),
                                 request.getParameter("password"));
    if (super.checkRegisteredUser(request, user)) {
      request.setAttribute("events", getEvents());
      return "events.jsp";
    } else {
      return "login.jsp";
    }
  }

  private ArrayList<EventBean> getEvents() {
    ArrayList<EventBean> events = new ArrayList<EventBean>();

    Date date = new Date();

    events.add(new EventBean("event1", "Description of event1", date, "UC3M",
                             "hall1", "/images/image1.png", 2, 6.25,
                             "CATEGORY"));
    events.add(new EventBean("event2", "Description of event2", date, "UC3M2",
                             "hall2", "/images/image2.png", 2, 6.25,
                             "CATEGORY"));
    events.add(new EventBean("event3", "Description of event3", date, "UC3M3",
                             "hall3", "/images/image3.png", 2, 6.25,
                             "CATEGORY"));

    return events;
  }
}
