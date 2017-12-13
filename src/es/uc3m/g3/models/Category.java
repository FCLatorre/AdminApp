package es.uc3m.g3.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="categoryBean")
	private List<Event> events;

	public Category() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setCategoryBean(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setCategoryBean(null);

		return event;
	}

}