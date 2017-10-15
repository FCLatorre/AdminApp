package es.uc3m.g3.bean;

import java.util.Date;


public class EventBean {
  private String id;
  private String title;
  private String description;
  private Date date;
  private String location;
  private String hall;
  private String image;
  private short tickets;
  private double price;
  private String category;

  public String getTitle() { return title; }
  public String getId() { return id; }
  public String getDescription() { return description; }
  public Date getDate() { return date; }
  public String getLocation() { return location; }
  public String getHall() { return hall; }
  public String getImage() { return image; }
  public short getTickets() { return tickets; }
  public double getPrice() { return price; }
  public String getCategory() { return category; }

  public void setId(String id) { this.id = id; }
  public void setTitle(String title) { this.title = title; }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setDate(Date date) { this.date = date; }
  public void setLocation(String location) { this.location = location; }
  public void setHall(String hall) { this.hall = hall; }
  public void setImage(String image) { this.image = image; }
  public void setTickets(short tickets) { this.tickets = tickets; }
  public void setPrice(double price) { this.price = price; }
  public void setCategory(String category) { this.category = category; }

  public EventBean() { super(); }
  public EventBean(String id, String title, String description, Date date,
                   String location, String hall, String image, short tickets,
                   double price, String category) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
    this.date = date;
    this.location = location;
    this.hall = hall;
    this.image = image;
    this.tickets = tickets;
    this.price = price;
    this.category = category;
  }
}
