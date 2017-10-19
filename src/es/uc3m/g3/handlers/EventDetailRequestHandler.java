package es.uc3m.g3.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.EventBean;

public class EventDetailRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in EventDetailGETRequestHandler");
		String id = request.getParameter("id");
		request.setAttribute("event", getEventById(id));
		return "eventdetail.jsp";
	}

	@Override
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Handling the request in EventDetailPOSTRequestHandler");
		String id = (String) request.getParameter("id");
		String name = (String) request.getParameter("eventName");
		String description = "D1";

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;

		try {
			dateFormat.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String location = (String) request.getParameter("location");
		String hall = (String) request.getParameter("hall");

		String img = (String) request.getParameter("img");

		Short tickets = Short.parseShort(request.getParameter("tickets"));
		Double price = Double.parseDouble(request.getParameter("price"));

		String category = (String) request.getParameter("category");

		EventBean event = new EventBean(id, name, description, date, location, hall, img, tickets, price, category);

		request.setAttribute("id", id);
        System.out.println("Updating event: "+id);
		return handleGETRequest(request, response);
	}

	@Override
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}

	@Override
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("delete");
		return "delete";
	}

	private ArrayList<EventBean> getEvents() {
		ArrayList<EventBean> events = new ArrayList<EventBean>();

		Date date = new Date();

		events.add(new EventBean("id001", "event1", "Description of event1", date, "UC3M", "hall1",
				"/images/image1.png", (short) 2, 6.25, "CATEGORY"));
		events.add(new EventBean("id002", "event2", "Description of event2", date, "UC3M2", "hall2",
				"/images/image2.png", (short) 2, 6.25, "CATEGORY"));
		events.add(new EventBean("id003", "event3", "Description of event3", date, "UC3M3", "hall3",
				"/images/image3.png", (short) 2, 6.25, "CATEGORY"));

		return events;
	}

	private EventBean getEventById(String id) {
		for (EventBean e : getEvents()) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}
}
